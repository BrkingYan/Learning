package ThinkingInJava.Reflect.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class Handler implements InvocationHandler {

    private Object proxied;
    private boolean doesManSayWords = true;

    Handler(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("getName")){
            doesManSayWords = false;
        }

        System.out.print("Foreign Ministry spokesman : \" ");
        if (!doesManSayWords){
            System.out.print("chair man does not say anything");
            doesManSayWords = false;
        }
        if (method.getName().equals("command")){
            System.out.print(" , but ");
        }
        Object methodReturnValue = method.invoke(proxied,args);
        System.out.println(" \"");

        System.out.println("proxy's name : " + proxy.getClass().getSimpleName());
        System.out.println("method : " + method);
        System.out.println("object to invoke this method : " + proxied);
        System.out.println("method args : " + args);
        if (args != null){
            System.out.println("args type : " + args.getClass().getSimpleName());
        }
        System.out.println("method return value is : " + methodReturnValue);
        return methodReturnValue;
    }
}

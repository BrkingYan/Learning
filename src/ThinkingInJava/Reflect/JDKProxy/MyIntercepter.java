package ThinkingInJava.Reflect.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyIntercepter implements InvocationHandler {

    private Object proxied;
    public Object getProxy(Object proxied){
        this.proxied = proxied;
        return Proxy.newProxyInstance(proxied.getClass().getClassLoader(),proxied.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy add: before method invoke");
        Object obj = method.invoke(proxied,args);
        System.out.println("proxy add: after method invoke");
        return obj;
    }
}

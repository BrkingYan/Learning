package ThinkingInJava.Reflect.DynamicProxyCGLIB;

import net.sf.cglib.proxy.*;


import java.lang.reflect.Method;

class MyIntercepter implements MethodInterceptor {

    Object getProxy(Class c){
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(c);

        enhancer.setCallback(this);

        return enhancer.create();
    }
    @Override
    public Object intercept(Object proxy, Method method, Object[] methodArgs, MethodProxy methodProxy) throws Throwable {
        System.out.println("before real object");

        Object result = methodProxy.invokeSuper(proxy,methodArgs);

        System.out.println("after real object");
        return result;
    }
}

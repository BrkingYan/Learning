package ThinkingInJava.Concurrent.CatchException;

import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory {
    /*
    *  ThreadFactory会一个线程进行一定处理
    *  如设置属性 (本例给传进来的线程设置了一个异常处理器，用于捕获该线程抛出的异常)
    *  还有添加额外信息等等
    * */
    @Override
    public Thread newThread(Runnable r) {
        System.out.println("********** message from handler factory ***********");
        System.out.println(this + " creating new handler Thread");
        Thread thread = new Thread(r);
        System.out.println("created " + thread);
        //可以用匿名内部类实现
        thread.setUncaughtExceptionHandler(new ExceptionHandler());//给线程加上异常处理器，并给控制台加上一些额外信息
        System.out.println("---has created a exception handler--: " + thread.getUncaughtExceptionHandler());
        System.out.println("********** message from handler factory ***********");
        System.out.println();
        return thread;
    }
}

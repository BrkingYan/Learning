package ThinkingInJava.Concurrent.CatchException;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*  setDefaultUncaughtExceptionHandler

*  这种方式不是通过ThreadFactory给Thread设置ExceptionHandler的，
*  而是直接通过Thread的静态方法设置，这样设置的话，所有Thread都会被设置这个Handler，
*  除非为某个Thread通过Factory设置了专有的Handler
* */
public class CaptureUncaughtException2 {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
        exec.shutdown();
    }
}

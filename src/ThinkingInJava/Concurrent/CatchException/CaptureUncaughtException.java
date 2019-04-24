package ThinkingInJava.Concurrent.CatchException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread());//executor�Ὣ��ExceptionThreadװ��handlerThreadFactory���д���
        exec.shutdown();
    }
}

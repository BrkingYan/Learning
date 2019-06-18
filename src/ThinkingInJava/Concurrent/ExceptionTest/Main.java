package ThinkingInJava.Concurrent.ExceptionTest;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ThreadPoolExecutor;

class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Task());
        t.start();
        Thread.sleep(2000);
        t.interrupt();
        System.out.println(t.isInterrupted());

    }
}

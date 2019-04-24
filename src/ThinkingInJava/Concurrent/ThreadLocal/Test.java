package ThinkingInJava.Concurrent.ThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0;i<5;i++){
            exec.execute(new AddTask(i));
        }
        Thread.sleep(20);
        //TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
}

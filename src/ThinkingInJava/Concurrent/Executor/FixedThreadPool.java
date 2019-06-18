package ThinkingInJava.Concurrent.Executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(9);
        for (int i = 0;i<5;i++){
            exec.execute(new Task());
        }
        System.out.println("activeCount:"+Thread.activeCount());
        exec.shutdown();
    }
}

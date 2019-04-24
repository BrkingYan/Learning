package ThinkingInJava.Concurrent.Executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0;i<5;i++){
            exec.execute(new Task());
        }
        exec.shutdown();
    }
}

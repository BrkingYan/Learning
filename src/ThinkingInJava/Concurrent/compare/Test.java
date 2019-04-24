package ThinkingInJava.Concurrent.compare;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        NumManager manager1 = new NumManager1();
        NumManager manager2 = new NumManager2();

        ExecutorService exec = Executors.newCachedThreadPool();
        IncreTask increTask1 = new IncreTask(manager1);
        //IncreTask increTask2 = new IncreTask(manager2);
        CheckTask checkTask1 = new CheckTask(manager1,1);
        CheckTask checkTask2 = new CheckTask(manager1,2);
        exec.execute(increTask1);
        //exec.execute(increTask2);
        exec.execute(checkTask1);
        exec.execute(checkTask2);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdown();
        System.exit(0);
    }
}

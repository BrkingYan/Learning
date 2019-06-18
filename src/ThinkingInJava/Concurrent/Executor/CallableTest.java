package ThinkingInJava.Concurrent.Executor;


import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0;i<5;i++){
            results.add(exec.submit(new TaskWithCallback(i)));//将任务提交
        }

        for (Future<String> fs : results){
            try {
                while (!fs.isDone()){
                    System.out.println("waiting for isDone()");
                    Thread.sleep(1000);
                }
                System.out.println("isDone : " + fs.isDone() + " " + fs.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
                //System.out.println("shutdown");
                
            }
        }
    }
}

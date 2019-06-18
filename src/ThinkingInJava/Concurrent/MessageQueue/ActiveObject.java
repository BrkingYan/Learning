package ThinkingInJava.Concurrent.MessageQueue;

import java.util.*;
import java.util.concurrent.*;

public class ActiveObject {
    private ExecutorService exec = Executors.newSingleThreadExecutor();
    private Random rand = new Random(47);

    private void pause(int factor){
        try {
            TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(factor));
        }catch (InterruptedException e){
            System.out.println("sleep() interrupted");
        }
    }

    Future<Integer> calculateInt(final int x,final int y){
        // submit a callable
        return exec.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("calculating int " + x + " + " + y + "...... = " + (x+y));
                pause(1000);
                return x + y;
            }
        });
    }

    Future<Float> calculateFloat(final float x,final float y){
        // submit a callable
        return exec.submit(new Callable<Float>() {
            @Override
            public Float call() throws Exception {
                System.out.println("calculating float " + x + " + " + y + "...... = " + (x+y));
                pause(3000);
                return x + y;
            }
        });
    }

    void shutdown(){
        exec.shutdown();
    }
}

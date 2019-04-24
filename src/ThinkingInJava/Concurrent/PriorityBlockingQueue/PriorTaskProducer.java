package ThinkingInJava.Concurrent.PriorityBlockingQueue;

import java.util.*;
import java.util.concurrent.*;

class PriorTaskProducer implements Runnable {
    private Random rand = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;
    PriorTaskProducer(Queue<Runnable> queue,ExecutorService exec){
        this.queue = queue;
        this.exec = exec;
    }
    @Override
    public void run() {
        for (int i = 0;i<20;i++){
            queue.add(new PriorTask(rand.nextInt(10)));
            Thread.yield();
        }

        try {
            for (int i = 0;i<10;i++){
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PriorTask(10));
            }
            for (int i = 0;i<10;i++){
                queue.add(new PriorTask(i));
            }
            //最后加上末端哨兵
            queue.add(new PriorTask.EndSential(exec));
        }catch (InterruptedException e){

        }
        System.out.println("priorTaskProducer finished !");
    }
}

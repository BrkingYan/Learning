package ThinkingInJava.Concurrent.PriorityBlockingQueue;

import java.util.concurrent.*;

class PriorTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> queue;

    PriorTaskConsumer(PriorityBlockingQueue<Runnable> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                //System.out.println("queue: "+queue);
                Runnable r = queue.take();//并不是启动PriorTask任务，而是调用它们的run()方法
                r.run();
                System.out.println("task run()");
            }
        }catch (InterruptedException e){

        }
        System.out.println("consumer finished");
    }
}

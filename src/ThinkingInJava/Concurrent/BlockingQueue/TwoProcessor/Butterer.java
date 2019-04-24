package ThinkingInJava.Concurrent.BlockingQueue.TwoProcessor;

import java.util.concurrent.*;

//加工者一
class Butterer implements Runnable {
    private LinkedBlockingQueue<Toast> finishedQueue;
    private LinkedBlockingQueue<Toast> dryQueue;
    private LinkedBlockingQueue<Toast> lackButerQueue;
    private LinkedBlockingQueue<Toast> lackJamQueue;

    Butterer(LinkedBlockingQueue<Toast> finishedQueue,
             LinkedBlockingQueue<Toast> dryQueue,
             LinkedBlockingQueue<Toast> lackButerQueue,
             LinkedBlockingQueue<Toast> lackJamQueue){
        this.finishedQueue = finishedQueue;
        this.dryQueue = dryQueue;
        this.lackButerQueue = lackButerQueue;
        this.lackJamQueue = lackJamQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("Butterer check the dryQueue");
                Toast dt = dryQueue.take();
                System.out.println("Buttering...");
                dt.buttered();
                lackJamQueue.put(dt);

                System.out.println("Butterer check the lackButterQueue");
                Toast t2 = lackButerQueue.take();
                System.out.println("Buttering...");
                t2.buttered();
                finishedQueue.put(t2);
            }
        }catch (InterruptedException e){
            System.out.println("Butterer interrupted");
        }
    }
}

package ThinkingInJava.Concurrent.BlockingQueue.TwoProcessor;

import java.util.concurrent.LinkedBlockingQueue;

//加工者二
class Jammer implements Runnable {

    private LinkedBlockingQueue<Toast> finishedQueue;
    private LinkedBlockingQueue<Toast> dryQueue;
    private LinkedBlockingQueue<Toast> lackJamQueue;
    private LinkedBlockingQueue<Toast> lackButterQueue;

    Jammer(LinkedBlockingQueue<Toast> finishedQueue,
           LinkedBlockingQueue<Toast> dryQueue,
           LinkedBlockingQueue<Toast> lackJamQueue,
           LinkedBlockingQueue<Toast> lackButterQueue){
        this.finishedQueue = finishedQueue;
        this.dryQueue = dryQueue;
        this.lackJamQueue = lackJamQueue;
        this.lackButterQueue = lackButterQueue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("Butterer check the dryQueue");
                Toast t1 = dryQueue.take();
                System.out.println("jamming...");
                t1.jamed();
                lackButterQueue.put(t1);

                System.out.println("Butterer check the lackJamQueue");
                Toast t2 = lackJamQueue.take();
                System.out.println("jamming...");
                t2.jamed();
                finishedQueue.put(t2);
            }
        }catch (InterruptedException e){
            System.out.println("Jammer interrupted");
        }
    }
}

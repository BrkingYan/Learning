package ThinkingInJava.Concurrent.BlockingQueue.TwoProcessor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Eater implements Runnable{

    private LinkedBlockingQueue<Toast> finishedQueue;
    private int count = 0;

    Eater(LinkedBlockingQueue<Toast> finishedQueue){
        this.finishedQueue = finishedQueue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(800);
                System.out.println("Eater check the finished queue");
                System.out.println("finished queue: " + finishedQueue);
                Toast t = finishedQueue.take();//µÈ´ýfinished queueÉÏµÄtoast
                if (t.getStatus() != Toast.Status.Finished){
                    System.out.println(">>> Error: " + t);
                    System.exit(1);
                }else {
                    System.out.println("Chomp! " + t);
                }
            }
        }catch (InterruptedException e){
            System.out.println("Eater interrupted");
        }
        System.out.println("Eater off");
    }

}

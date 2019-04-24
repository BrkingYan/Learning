package ThinkingInJava.Concurrent.BlockingQueue;

import java.util.concurrent.*;

/*
* 任务三：涂抹果酱
* */
class Jammer implements Runnable {
    private LinkedBlockingQueue<Toast> butteredQueue,finishedQueue;

    Jammer(LinkedBlockingQueue<Toast> butteredQueue,LinkedBlockingQueue<Toast> finishedQueue){
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(400);
                System.out.println("Jammer check the queue");
                System.out.println("buttered toast queue: " + butteredQueue);
                System.out.println("finished toast queue: " + finishedQueue);
                Toast t = butteredQueue.take();//等待buttered queue上的toast
                System.out.println("jamming ......");
                //TimeUnit.SECONDS.sleep(2);
                t.jamed();
                System.out.println("toast info : " + t);
                finishedQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("Jammer interrupted");
        }
        System.out.println("Jammer off");
    }
}

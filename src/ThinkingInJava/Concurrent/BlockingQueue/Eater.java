package ThinkingInJava.Concurrent.BlockingQueue;

import java.util.concurrent.*;

/*
* 任务四：吃掉toast
* */
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
                Toast t = finishedQueue.take();//等待finished queue上的toast
                if (t.getId() != count++ || t.getStatus() != Toast.Status.JAMMED){
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

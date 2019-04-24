package ThinkingInJava.Concurrent.BlockingQueue;

import java.util.Random;
import java.util.concurrent.*;

/*
* ����һ������toast
* */
class Toaster implements Runnable{

    private LinkedBlockingQueue<Toast> toastQueue;
    private int count = 0;
    private Random rand = new Random(47);

    Toaster(LinkedBlockingQueue<Toast> toastQueue){
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100);//ÿ100��������һ��toast
                System.out.println("Toaster check the queue");
                System.out.println("toast queue: " + toastQueue);
                System.out.println("making toast ......");
                //TimeUnit.SECONDS.sleep(2);
                Toast t = new Toast(count++);
                System.out.println("toast info : " + t);
                toastQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("Toaster interrupted");
        }
    }
}

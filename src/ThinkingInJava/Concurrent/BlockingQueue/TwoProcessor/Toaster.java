package ThinkingInJava.Concurrent.BlockingQueue.TwoProcessor;

import java.util.concurrent.*;
import java.util.*;

//������
class Toaster implements Runnable{

    private LinkedBlockingQueue<Toast> dryQueue;
    private int count = 0;
    private Random rand = new Random(47);

    Toaster(LinkedBlockingQueue<Toast> toastQueue){
        this.dryQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100);//ÿ100��������һ��toast
                //TimeUnit.SECONDS.sleep(2);
                Toast t = new Toast(count++);
                dryQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("Toaster interrupted");
        }
    }
}

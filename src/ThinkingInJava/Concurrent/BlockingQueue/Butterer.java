package ThinkingInJava.Concurrent.BlockingQueue;

import java.util.concurrent.*;

/*
* �������ͿĨ����
* */
class Butterer implements Runnable {
    private LinkedBlockingQueue<Toast> dryQueue,butteredToastQueue;

    Butterer(LinkedBlockingQueue<Toast> dryQueue,LinkedBlockingQueue<Toast> butteredToastQueue){
        this.dryQueue = dryQueue;
        this.butteredToastQueue = butteredToastQueue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println("Butterer check the queue ***************");
                System.out.println("toast queue: " + dryQueue);
                System.out.println("buttered toast queue: " + butteredToastQueue);
                Toast t = dryQueue.take();//take()�������ûȡ����������
                System.out.println("buttering ......");
                //TimeUnit.SECONDS.sleep(2);
                t.buttered();
                System.out.println("toast info : " + t);
                butteredToastQueue.put(t);//����buttered queue
            }
        }catch (InterruptedException e){
            System.out.println("Butterer interrupted");
        }
        System.out.println("Butteer off");
    }
}

package ThinkingInJava.Concurrent.ThreadFactory;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;

class DaemonFromFactory implements Runnable {

    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0;i<5;i++){
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("all daemon started ");
        TimeUnit.MILLISECONDS.sleep(101);
    }
}

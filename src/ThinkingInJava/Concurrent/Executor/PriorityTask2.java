package ThinkingInJava.Concurrent.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PriorityTask2 implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;

    private PriorityTask2(int priority){
        this.priority = priority;
    }

    public String toString(){
        return Thread.currentThread() + ": " + countDown;
    }


    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        /*while (true){
            for (int i = 0;i<10000;i++){
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0){
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0){
                return;
            }
        }*/
        System.out.println(this);
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0;i<5;i++){
            exec.execute(new PriorityTask2(Thread.MIN_PRIORITY));
        }
        exec.execute(new PriorityTask2(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}

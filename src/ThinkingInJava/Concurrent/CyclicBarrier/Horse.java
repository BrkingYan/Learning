package ThinkingInJava.Concurrent.CyclicBarrier;


import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

class Horse implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;

    Horse(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    synchronized int getStrides(){
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    strides += rand.nextInt(3);//每个马一次跑1、2 或 3 米
                }
                /************* wait ****************/
                barrier.await();//等待所有任务都跑完一次，否则就一直等待
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }catch (BrokenBarrierException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

    String tracks(){
        StringBuilder s = new StringBuilder();
        for (int i = 0;i<getStrides();i++){
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }
}

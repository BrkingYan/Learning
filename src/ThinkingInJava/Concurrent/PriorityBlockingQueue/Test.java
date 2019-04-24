package ThinkingInJava.Concurrent.PriorityBlockingQueue;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

class Test {
    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        exec.execute(new PriorTaskProducer(queue,exec));
        exec.execute(new PriorTaskConsumer(queue));
    }
}

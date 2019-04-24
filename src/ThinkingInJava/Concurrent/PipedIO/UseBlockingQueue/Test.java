package ThinkingInJava.Concurrent.PipedIO.UseBlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Test {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Character> queue = new LinkedBlockingQueue<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Sender(queue));
        exec.execute(new Receiver(queue));
        TimeUnit.SECONDS.sleep(6);
        exec.shutdownNow();
    }
}

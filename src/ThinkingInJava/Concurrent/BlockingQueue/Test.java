package ThinkingInJava.Concurrent.BlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Test {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Toast> dryQueue = new LinkedBlockingQueue<>(),
                                   butteredQueue = new LinkedBlockingQueue<>(),
                                   finishedQueue = new LinkedBlockingQueue<>();

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue,butteredQueue));
        exec.execute(new Jammer(butteredQueue,finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }
}

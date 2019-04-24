package ThinkingInJava.Concurrent.BlockingQueue.TwoProcessor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/*
* 这里面Butterer与Jammer是独立的，不存在先后问题
* */
class Test {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Toast> dryQueue = new LinkedBlockingQueue<>(),
                finishedQueue = new LinkedBlockingQueue<>(),
                lackButterQueue = new LinkedBlockingQueue<>(),
                lackJamQueue = new LinkedBlockingQueue<>();

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(finishedQueue,dryQueue,lackButterQueue,lackJamQueue));
        exec.execute(new Jammer(finishedQueue,dryQueue,lackJamQueue,lackButterQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }
}

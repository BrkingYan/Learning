package ThinkingInJava.Concurrent.TryLock;

import java.util.concurrent.locks.ReentrantLock;

public class TryLockTest {
    private final AttemptLocking attempt = new AttemptLocking();
    private ReentrantLock lock;

    private TryLockTest(){
        this.lock = attempt.getLock();
    }
    public static void main(String[] args) {
        TryLockTest test = new TryLockTest();
        test.test();
    }

    private void test(){
        attempt.untimedTry();
        attempt.timedTry();

        Thread thread = new Thread(new Task());
        thread.setDaemon(true);
        lock.lock();
        thread.start();
        Thread.yield();

        attempt.untimedTry();
        attempt.timedTry();
    }

    private class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("acquired");

        }
    }
}

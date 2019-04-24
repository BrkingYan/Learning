package ThinkingInJava.Concurrent.sharedResource;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*  采用Lock方式
* */
class MutexEvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();
    @Override
    int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            //next2();
            return currentEvenValue;
        }finally {
            lock.unlock();
        }
    }

    private int next2() {
        System.out.println("next()2 run");
        ++currentEvenValue;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ++currentEvenValue;
        return currentEvenValue;
    }
}

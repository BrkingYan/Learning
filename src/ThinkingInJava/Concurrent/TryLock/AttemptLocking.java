package ThinkingInJava.Concurrent.TryLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    void untimedTry(){
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock() result : " + captured);
        }finally {
            if (captured){
                //System.out.println("非计时法获取到锁了，然后释放锁");
                lock.unlock();
            }
        }
    }

    void timedTry(){
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);//等两秒钟，如果没获取到锁，就false
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        try {
            System.out.println("tryLock(2,TimeUnit.SECONDS : )" + captured);
        }finally {
            if (captured){
                //System.out.println("计时法获取到锁了，然后释放锁");
                lock.unlock();
            }
        }
    }

    public ReentrantLock getLock() {
        return lock;
    }
}

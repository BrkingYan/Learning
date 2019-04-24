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
                //System.out.println("�Ǽ�ʱ����ȡ�����ˣ�Ȼ���ͷ���");
                lock.unlock();
            }
        }
    }

    void timedTry(){
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);//�������ӣ����û��ȡ��������false
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        try {
            System.out.println("tryLock(2,TimeUnit.SECONDS : )" + captured);
        }finally {
            if (captured){
                //System.out.println("��ʱ����ȡ�����ˣ�Ȼ���ͷ���");
                lock.unlock();
            }
        }
    }

    public ReentrantLock getLock() {
        return lock;
    }
}

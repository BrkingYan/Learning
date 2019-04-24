package ThinkingInJava.Concurrent.Automic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicTest implements Runnable{

    private int i = 0;
    int getValue(){
        System.out.println(i);
        return i;
    }

    synchronized private void increaseValue(){
        i++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
    }

    @Override
    public void run() {
        while (true){
            increaseValue();
        }
    }

    public static void main(String[] args) {
        AtomicTest task = new AtomicTest();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(task);//���߳̿�ʼִ��

        //���ͬʱ�����̼߳���ִ��
        while (true){
            int val = task.getValue();
            if (val % 2 != 0){
                System.out.println(val + " is not even ");
                System.exit(0);
            }
        }
    }
}

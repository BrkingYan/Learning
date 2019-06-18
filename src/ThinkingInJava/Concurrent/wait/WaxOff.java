package ThinkingInJava.Concurrent.wait;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class WaxOff implements Runnable{

    private Car car;

    WaxOff(Car car){
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                car.waitForWax();//����Ƿ����������û�Ͼ�wait()�ڴ˴�������������˾ͼ���ִ��
                System.out.println("wax off ...");//��������
                TimeUnit.MILLISECONDS.sleep(500);
                car.buffed();//��ɺ����Car��״̬�������������߳�
            }
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.println("buff task over");
    }
}

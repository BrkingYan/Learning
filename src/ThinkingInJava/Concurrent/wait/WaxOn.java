package ThinkingInJava.Concurrent.wait;

import java.util.concurrent.TimeUnit;

class WaxOn implements Runnable{

    private Car car;

    WaxOn(Car car){
        this.car = car;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("wax on ...");//��������
                TimeUnit.MILLISECONDS.sleep(500);
                car.waxed();//����Car״̬����֪ͨ�����߳�
                car.waitForBuff();
            }
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.println("wax task over");
    }
}

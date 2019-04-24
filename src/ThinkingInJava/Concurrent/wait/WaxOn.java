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
                System.out.println("wax on ...");//上蜡操作
                TimeUnit.MILLISECONDS.sleep(500);
                car.waxed();//更新Car状态，并通知其他线程
                car.waitForBuff();
            }
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.println("wax task over");
    }
}

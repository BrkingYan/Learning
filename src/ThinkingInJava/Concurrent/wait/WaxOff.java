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
                car.waitForWax();//检查是否上蜡，如果没上就wait()在此处阻塞，如果上了就继续执行
                System.out.println("wax off ...");//上蜡操作
                TimeUnit.MILLISECONDS.sleep(500);
                car.buffed();//完成后更新Car的状态，并唤醒其他线程
            }
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.println("buff task over");
    }
}

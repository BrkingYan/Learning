package ThinkingInJava.Concurrent.wait;

class Car {
    private boolean waxOn = false;

    //上蜡完成，通知其他线程
    synchronized void waxed(){
        waxOn = true;
        notifyAll();
    }

    //去蜡完成，通知其他线程
    synchronized void buffed(){
        waxOn = false;
        notifyAll();
    }

    //等待上蜡
    synchronized void waitForWax() throws InterruptedException {
        while (waxOn == false){
            wait();
        }
    }
    //等待去蜡
    synchronized void waitForBuff() throws InterruptedException {
        while (waxOn == true){
            wait();
        }
    }
}

package ThinkingInJava.Concurrent.Join;


/*
*  一个可以掺和到其他线程的线程
*  它join到其他线程，其他线程必须等他睡醒时候才能继续执行
* */
class Sleeper extends Thread {
    private int duration;

    Sleeper(String name,int sleepTime){
        super(name);
        this.duration = sleepTime;
        start();
    }

    Sleeper(String name){
        super(name);
    }
    @Override
    public void run() {
        try {
            sleep(duration);
            if (!isInterrupted()){
                System.out.println(getName() + " 睡觉中...");
            }
        } catch (InterruptedException e) {
            //System.err.println(getName() + " was interrupted " + " isInterrupted() " + isInterrupted());
            System.err.println(getName() + " 中途被吵醒了");
            Thread.currentThread().interrupt();
        }
        System.out.println(getName() + " 睡醒了");
    }
}

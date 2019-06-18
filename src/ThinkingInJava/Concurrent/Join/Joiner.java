package ThinkingInJava.Concurrent.Join;


import java.util.concurrent.atomic.AtomicInteger;

/*
*  该线程持有一个Sleeper线程，
*  可以调用sleeper的join()方法，让sleeper过来睡觉来打发时间
* */
class Joiner extends Thread {
    private Sleeper sleeper;

    Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
    }

    @Override
    public void run() {
        try {
            System.out.println(sleeper.getName() + " 过来睡觉了");
            sleeper.join();//Joiner等待sleeper醒来才继续执行
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        //System.out.println(getName() + " join completed");
    }
}

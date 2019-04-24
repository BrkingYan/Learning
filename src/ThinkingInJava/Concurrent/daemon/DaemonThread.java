package ThinkingInJava.Concurrent.daemon;

import java.util.concurrent.TimeUnit;

class DaemonThread implements Runnable {

    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(175);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                System.err.println("sleep() interrupted");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0;i<10;i++){
            Thread thread = new Thread(new DaemonThread());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("all daemon started ");
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}

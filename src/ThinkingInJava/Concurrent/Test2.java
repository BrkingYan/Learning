package ThinkingInJava.Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Test2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Runnable(){
            @Override
            public void run() {
                synchronized (this){
                    try {
                        System.out.println("thread is wait()");
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("interrupted when wait()");
                    }
                }
            }
        });
        Thread.sleep(2000);
        exec.shutdownNow();
    }
}

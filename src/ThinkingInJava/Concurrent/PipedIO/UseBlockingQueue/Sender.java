package ThinkingInJava.Concurrent.PipedIO.UseBlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable {
    LinkedBlockingQueue<Character> queue;

    Sender(LinkedBlockingQueue<Character> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                for (char c = 'A';c < 'z';c++){
                    TimeUnit.MILLISECONDS.sleep(800);
                    queue.put(c);
                    System.out.println("sender put char-" + c);
                }
            }
        }catch (InterruptedException e){
            System.out.println("Sender interrupted");
        }
    }
}

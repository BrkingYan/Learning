package ThinkingInJava.Concurrent.PipedIO.UseBlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

class Receiver implements Runnable {
    private LinkedBlockingQueue<Character> queue;
    Receiver(LinkedBlockingQueue<Character> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                char ch = queue.take();
                System.out.println("receiver get char-" + ch);
            }
        }catch (InterruptedException e){
            System.out.println("Receiver interrupted");
        }
    }
}

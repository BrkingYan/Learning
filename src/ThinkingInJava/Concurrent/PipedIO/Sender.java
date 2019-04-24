package ThinkingInJava.Concurrent.PipedIO;

import java.io.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable {

    private Random rand = new Random(47);
    private PipedWriter out = new PipedWriter();

    PipedWriter getPipedWriter(){
        return out;
    }
    @Override
    public void run() {
        try {
            while (true){
                for (char c = 'A';c < 'z';c++){
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        }catch (IOException e){
            System.out.println(e + " Sender write exception");
        }catch (InterruptedException e){
            System.out.println(e + " Sender sleep interrupted");
        }
    }
}

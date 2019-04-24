package ThinkingInJava.Concurrent.NioBreakdown;

import java.io.IOException;
import java.io.InputStream;

class IOBlockedTask implements Runnable {

    private InputStream in;
    IOBlockedTask(InputStream in){
        this.in = in;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read()");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted from blocked I/O");
            }else {
                throw new RuntimeException(e);
            }
            System.out.println("interrupt success !");
        }
    }
}

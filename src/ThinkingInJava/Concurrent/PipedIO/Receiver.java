package ThinkingInJava.Concurrent.PipedIO;

import java.io.IOException;
import java.io.PipedReader;

class Receiver implements Runnable {

    private PipedReader in;
    Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPipedWriter());
    }
    @Override
    public void run() {
        try {
            while (true){
                System.out.print("Read: " + (char)in.read() + ", ");
            }
        }catch (IOException e){
            System.out.println(e + " Receiver read exception");
        }
    }
}

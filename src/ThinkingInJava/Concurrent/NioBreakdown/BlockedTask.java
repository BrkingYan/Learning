package ThinkingInJava.Concurrent.NioBreakdown;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;

class BlockedTask implements Runnable {

    private final SocketChannel channel;

    BlockedTask(SocketChannel channel){
        this.channel = channel;
    }
    @Override
    public void run() {

        try {
            System.out.println("waiting for read()");
            channel.read(ByteBuffer.allocate(1));
        }catch (ClosedByInterruptException e){
            System.out.println("Closed by interrupt exception");
        }catch (AsynchronousCloseException e){
            System.out.println("asynchronous close exception");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("exiting run()");
    }
}

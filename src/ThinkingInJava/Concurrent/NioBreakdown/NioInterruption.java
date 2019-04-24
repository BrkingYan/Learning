package ThinkingInJava.Concurrent.NioBreakdown;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class NioInterruption {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);

        InetSocketAddress address = new InetSocketAddress("localhost",8080);
        SocketChannel channel1 = SocketChannel.open(address);
        SocketChannel channel2 = SocketChannel.open(address);

        Future<?> f = exec.submit(new BlockedTask(channel1));
        exec.execute(new BlockedTask(channel2));

        TimeUnit.SECONDS.sleep(1);


        // NIO��������ʱ������ж��߳�
        // ��1
        f.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        // ��2
        exec.shutdownNow();

        //�ر���ԴҲ���ж�
        //channel2.close();
    }
}

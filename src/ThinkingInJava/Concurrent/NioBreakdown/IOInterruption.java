package ThinkingInJava.Concurrent.NioBreakdown;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class IOInterruption {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InetSocketAddress address = new InetSocketAddress("localhost",8080);

        Future<?> f = exec.submit(new IOBlockedTask(System.in));
        TimeUnit.SECONDS.sleep(1);

        f.cancel(true);// IO 阻塞的时候无法中断线程
        System.in.close();//只能通过关闭资源中断
    }
}

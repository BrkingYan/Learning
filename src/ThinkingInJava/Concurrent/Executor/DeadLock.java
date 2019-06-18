package ThinkingInJava.Concurrent.Executor;

import java.util.concurrent.*;

public class DeadLock {
    ExecutorService exec = Executors.newCachedThreadPool();
    ThreadPoolExecutor executor = new ThreadPoolExecutor(1,2,0L,TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(12));


//	  ExecutorService exec = Executors.newCachedThreadPool();    //如果添加给线程池中添加足够多的线程，就可以让所有任务都执行，避免饥饿死锁。

    /**
     * 模拟页面加载的例子
     *
     * 产生死锁分析：
     * RenderPageTask任务中有2个子任务分别是“加载页眉”和“加载页脚”。当提交RenderPageTask任务时，实际上是向线程池中添加了3个任务，
     * 但是由于线程池是单一线程池，同时只会执行一个任务，2个子任务就会在阻塞在线程池中。而RenderPageTask任务由于得不到返回，也会
     * 一直堵塞，不会释放线程资源让子线程执行。这样就导致了线程饥饿死锁。
     *
     * 在一个Callable任务中，要返回2个子任务
     * @author hadoop
     *
     */
    class RenderPageTask implements Callable<String>{

        //父任务先进去，先执行，执行到半路启动了子任务，因此子任务会阻塞
        @Override
        public String call() throws Exception {
            Future<String>  header,footer,future3,future4;

            //子任务1
            header = exec.submit(new Callable<String>(){
                @Override
                public String call() throws Exception {
                    System.out.println("加载页眉");
                    Thread.sleep(2*1000);
                    return "页眉";
                }
            });

            //子任务2
            footer = exec.submit(new Callable<String>(){
                @Override
                public String call() throws Exception {
                    System.out.println("加载页脚");
                    Thread.sleep(3*1000);
                    return "页脚";
                }
            });

            //子任务3
            future3 = exec.submit(new Callable<String>(){
                @Override
                public String call() throws Exception {
                    System.out.println("task 3");
                    Thread.sleep(1*1000);
                    return " task 3";
                }
            });

            //子任务4
            future4 = exec.submit(new Callable<String>(){
                @Override
                public String call() throws Exception {
                    System.out.println("task 4");
                    Thread.sleep(2*1000);
                    return " task 4";
                }
            });

            System.out.println("渲染页面主体");

            return header.get() + footer.get() + future3.get() + future4.get();
        }

    }

    private Future<String> exec(){
        return exec.submit(new RenderPageTask());
    }

    private void shutdown(){
        exec.shutdown();
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        DeadLock td = new DeadLock();
        Future<String> futre = td.exec();
        String result = futre.get();
        System.out.println("执行结果为："  +  result);
        td.shutdown();
    }
}

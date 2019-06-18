package ThinkingInJava.Concurrent.Executor;

import java.util.concurrent.*;

public class DeadLock {
    ExecutorService exec = Executors.newCachedThreadPool();
    ThreadPoolExecutor executor = new ThreadPoolExecutor(1,2,0L,TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(12));


//	  ExecutorService exec = Executors.newCachedThreadPool();    //�����Ӹ��̳߳�������㹻����̣߳��Ϳ�������������ִ�У����⼢��������

    /**
     * ģ��ҳ����ص�����
     *
     * ��������������
     * RenderPageTask��������2��������ֱ��ǡ�����ҳü���͡�����ҳ�š������ύRenderPageTask����ʱ��ʵ���������̳߳��������3������
     * ���������̳߳��ǵ�һ�̳߳أ�ͬʱֻ��ִ��һ������2��������ͻ����������̳߳��С���RenderPageTask�������ڵò������أ�Ҳ��
     * һֱ�����������ͷ��߳���Դ�����߳�ִ�С������͵������̼߳���������
     *
     * ��һ��Callable�����У�Ҫ����2��������
     * @author hadoop
     *
     */
    class RenderPageTask implements Callable<String>{

        //�������Ƚ�ȥ����ִ�У�ִ�е���·��������������������������
        @Override
        public String call() throws Exception {
            Future<String>  header,footer,future3,future4;

            //������1
            header = exec.submit(new Callable<String>(){
                @Override
                public String call() throws Exception {
                    System.out.println("����ҳü");
                    Thread.sleep(2*1000);
                    return "ҳü";
                }
            });

            //������2
            footer = exec.submit(new Callable<String>(){
                @Override
                public String call() throws Exception {
                    System.out.println("����ҳ��");
                    Thread.sleep(3*1000);
                    return "ҳ��";
                }
            });

            //������3
            future3 = exec.submit(new Callable<String>(){
                @Override
                public String call() throws Exception {
                    System.out.println("task 3");
                    Thread.sleep(1*1000);
                    return " task 3";
                }
            });

            //������4
            future4 = exec.submit(new Callable<String>(){
                @Override
                public String call() throws Exception {
                    System.out.println("task 4");
                    Thread.sleep(2*1000);
                    return " task 4";
                }
            });

            System.out.println("��Ⱦҳ������");

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
        System.out.println("ִ�н��Ϊ��"  +  result);
        td.shutdown();
    }
}

package ThinkingInJava.Concurrent.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
*  execute(Runnable command) �ڽ���ĳ��ʱ��ִ�и�������
* */
class ThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();//���ص���һ��ThreadPoolExecutor
        for (int i = 0;i<5;i++){
            exec.execute(new Task());
        }
        exec.shutdown();
    }
}

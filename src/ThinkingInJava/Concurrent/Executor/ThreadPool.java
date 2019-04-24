package ThinkingInJava.Concurrent.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
*  execute(Runnable command) 在将来某个时间执行给定任务。
* */
class ThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();//返回的是一个ThreadPoolExecutor
        for (int i = 0;i<5;i++){
            exec.execute(new Task());
        }
        exec.shutdown();
    }
}

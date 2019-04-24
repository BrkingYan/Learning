package ThinkingInJava.Concurrent.Executor;


import java.util.concurrent.*;


class TaskWithCallback implements Callable<String> {
    private int sleepTime;
    private int id;

    TaskWithCallback(int id){
        this.id  = id;
        this.sleepTime = 500 * id;
    }


    @Override
    public String call() throws Exception {
        Thread.sleep(sleepTime);
        if (sleepTime == 1500){
            throw new RuntimeException("interrupted");//第三个任务失败，但是其他任务照常进行
        }
        return "callback message : " + id;
    }

}

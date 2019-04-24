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
            throw new RuntimeException("interrupted");//����������ʧ�ܣ��������������ճ�����
        }
        return "callback message : " + id;
    }

}

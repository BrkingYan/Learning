package ThinkingInJava.Concurrent.Executor;


class Task implements Runnable{
    private int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    Task(){}

    Task(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#task-" + id + "(" + (countDown > 0? countDown : "LiftOff!") + "), ";
    }

    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.print(status());
            System.out.println("***current thread :" + Thread.currentThread());
            Thread.yield();
        }
        System.out.println("over");
    }
}

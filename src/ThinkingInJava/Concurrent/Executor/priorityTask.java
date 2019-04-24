package ThinkingInJava.Concurrent.Executor;

import java.util.concurrent.*;

class priorityTask implements Runnable {
    private int countDown = 3;
    private int priority;
    private static int taskCount = 0;
    private final int id = taskCount++;
    private volatile double data;

    priorityTask(){}

    priorityTask(int priority){
        this.priority = priority;
        //Thread.currentThread().setPriority(priority);
    }

    public String status(){
        return "#task-" + id + " priority : " + priority + "\n";
    }

    @Override
    public void run() {
        //System.out.println("into run()");
        Thread.currentThread().setPriority(priority);
        System.out.print(status());
        /*while (countDown-- > 0){
            Thread.yield();
        }*/
        /*for (int j = 0;j < 10000;j++){
            data += (Math.PI + Math.E) / (double) j;
            if (j % 1000 == 0){
                Thread.yield();
            }
        }*/
        Thread.yield();
        System.out.println( "task-" + id + " over");
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0;i<5;i++){
            Future f = exec.submit(new priorityTask(Thread.MIN_PRIORITY));
            /*while (true){
                if (f.isDone()){
                    System.out.println("isDone");
                    break;
                }
            }*/

        }

        for (int i = 0;i<5;i++){
            Future ff = exec.submit(new priorityTask(Thread.MAX_PRIORITY));
            /*while (true){
                if (f.isDone()){
                    System.out.println("isDone");
                    break;
                }
            }*/

        }


        exec.shutdown();
    }
}

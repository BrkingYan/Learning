package ThinkingInJava.Concurrent.PriorityBlockingQueue;

import java.util.*;
import java.util.concurrent.*;

public class PriorTask implements Runnable,Comparable<PriorTask> {
    private Random rand = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    protected static List<PriorTask> taskList = new ArrayList<>();

    static class EndSential extends PriorTask{
        private ExecutorService exec;

        EndSential(ExecutorService exec) {
            super(-1);
            this.exec = exec;
        }

        /*
        *  这个是末端哨兵的run()方法
        * */
        @Override
        public void run() {
            System.out.println("in run()");
            int count = 0;
            for (PriorTask task : taskList){
                System.out.println(task.summary());
                if (++count % 5 == 0){
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }

    PriorTask(int priority){
        this.priority = priority;
        taskList.add(this);
    }
    @Override
    public int compareTo(PriorTask task) {
        if (priority > task.priority){
            return 1;
        }else if (priority < task.priority){
            return -1;
        }else {
            return 0;
        }
        //return priority > task.priority ? 1 : (priority > task.priority ? -1 : 0);
    }

    /*
    * 这个是PriorTask的run()方法
    * */
    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        }catch (InterruptedException e){

        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("[%1$-1d]",priority )+ " Task " + id;
    }

    private String summary(){
        return "(" + id + ":" + priority + ")";
    }
}

package ThinkingInJava.Concurrent.ThreadLocal;

class AddTask implements Runnable {

    private final int taskId;

    AddTask(int taskId){
        this.taskId = taskId;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            ThreadLocalVarHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "Task-" + taskId + ": " + ThreadLocalVarHolder.getValue();
    }
}

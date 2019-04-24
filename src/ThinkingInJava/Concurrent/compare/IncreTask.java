package ThinkingInJava.Concurrent.compare;

public class IncreTask implements Runnable{
    private NumManager manager;

    IncreTask(NumManager manager){
        this.manager = manager;
    }
    @Override
    public void run() {
        while (true){
            manager.increment();
        }
    }
}

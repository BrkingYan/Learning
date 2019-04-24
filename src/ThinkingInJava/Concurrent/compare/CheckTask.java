package ThinkingInJava.Concurrent.compare;

class CheckTask implements Runnable {
    private NumManager manager;
    private int id;

    CheckTask(NumManager manager,int id){
        this.id = id;
        this.manager = manager;

    }
    @Override
    public void run() {
        while (true){
            manager.getNumber().checkState();
        }
    }

    public String toString(){
        return "checker : " + id;
    }
}

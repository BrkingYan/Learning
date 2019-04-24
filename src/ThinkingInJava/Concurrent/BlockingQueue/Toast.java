package ThinkingInJava.Concurrent.BlockingQueue;

class Toast {
    enum Status{
        DRY,BUTTERED,JAMMED
    }

    private Status  status = Status.DRY;
    private final int id;

    Toast(int id){
        this.id = id;
    }

    void buttered(){
        status = Status.BUTTERED;
    }

    void jamed(){
        status = Status.JAMMED;
    }

    int getId(){
        return id;
    }

    Status getStatus(){
        return status;
    }

    @Override
    public String toString() {
        return "Toast " + id + ": " + status;
    }
}

package ThinkingInJava.Concurrent.BlockingQueue.TwoProcessor;

class Toast {
    enum Status{
        DRY,BUTTERED,JAMMED,Finished
    }

    private Status  status = Status.DRY;
    private final int id;

    Toast(int id){
        this.id = id;
    }

    void buttered(){
        if (status == Status.DRY){
            status = Status.BUTTERED;
        }else if (status == Status.JAMMED){
            status = Status.Finished;
        }
    }

    void jamed(){
        if (status == Status.DRY)
            status = Status.JAMMED;
        else if (status == Status.BUTTERED)
            status = Status.Finished;
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

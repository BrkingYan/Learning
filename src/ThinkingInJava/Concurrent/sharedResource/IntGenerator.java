package ThinkingInJava.Concurrent.sharedResource;

abstract class IntGenerator {
    private volatile boolean canceled = false;
    abstract int next();

    void cancel(){
        canceled = true;
    }

    boolean isCanceled(){
        return canceled;
    }
}

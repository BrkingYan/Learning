package ConcurrentInPractice;

class Holder {
    private int n;
    Holder(int n){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.n = n;
    }

    void assertSanity(int n){
        if (this.n != n){
            throw new RuntimeException("false");
        }
        System.out.println("current thread : " + Thread.currentThread().getName());
    }

    int getN(){
        return n;
    }
}

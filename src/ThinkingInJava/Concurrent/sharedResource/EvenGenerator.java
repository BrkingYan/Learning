package ThinkingInJava.Concurrent.sharedResource;

/*
* 该类作为共享资源
* */
class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        //next2();
        return currentEvenValue;
    }

    private int next2() {
        System.out.println("next()2 run");
        ++currentEvenValue;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ++currentEvenValue;
        return currentEvenValue;
    }
}

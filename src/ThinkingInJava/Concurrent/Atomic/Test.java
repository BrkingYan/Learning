package ThinkingInJava.Concurrent.Atomic;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    private static final int SIZE = 10;
    public static void main(String[] args) {
        for (int i = 0;i<SIZE;i++){
            exec.execute(new SetChecker.NumberChecker());
        }
    }

}

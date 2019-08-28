package ThinkingInJava.Concurrent.ForkJoin;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class ArrCalTask extends RecursiveTask<Integer> {
    private int[] arr;
    private int start;
    private int end;
    private static final int MAX = 70;

    ArrCalTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        // 当end-start的值小于MAX时候，开始打印
        if ((end - start) < MAX) {
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        } else {
            System.err.println("=====任务分解======");
            // 将大任务分解成两个小任务
            int middle = (start + end) / 2;
            ArrCalTask left = new ArrCalTask(arr, start, middle);
            ArrCalTask right = new ArrCalTask(arr, middle, end);
            // 并行执行两个小任务
            left.fork();
            right.fork();
            // 把两个小任务累加的结果合并起来
            return left.join() + right.join();
        }
    }
}
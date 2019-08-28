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
        // ��end-start��ֵС��MAXʱ�򣬿�ʼ��ӡ
        if ((end - start) < MAX) {
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        } else {
            System.err.println("=====����ֽ�======");
            // ��������ֽ������С����
            int middle = (start + end) / 2;
            ArrCalTask left = new ArrCalTask(arr, start, middle);
            ArrCalTask right = new ArrCalTask(arr, middle, end);
            // ����ִ������С����
            left.fork();
            right.fork();
            // ������С�����ۼӵĽ���ϲ�����
            return left.join() + right.join();
        }
    }
}
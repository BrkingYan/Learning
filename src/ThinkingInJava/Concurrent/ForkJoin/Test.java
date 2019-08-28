package ThinkingInJava.Concurrent.ForkJoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random rand = new Random();
        int sum = 0;
        for (int i = 0;i<arr.length;i++){
            arr[i] = rand.nextInt(10);
            sum += arr[i];
        }
        System.out.println("result real : "+ sum);
        ForkJoinPool pool = new ForkJoinPool();
        Integer integer = pool.invoke(new ArrCalTask(arr,0,arr.length));
        System.out.println("result from fork join: " + integer);
        pool.shutdown();
    }
}

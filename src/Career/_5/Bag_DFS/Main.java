package Career._5.Bag_DFS;

/*
* 牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。

输入：3 10
      1 2 4

输出：8
* */
import java.util.*;
public class Main{
    private static int count;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int snakeNum = sc.nextInt();
        int bagV = sc.nextInt();
        int[] snakes = new int[snakeNum];
        for(int i = 0;i<snakeNum;i++){
            snakes[i] = sc.nextInt();
        }
        if(sum(snakes) <= bagV){
            System.out.println((long)Math.pow(2,snakeNum));
        }else{
            sort(snakes);
            dfs(0,0,snakes,bagV,snakeNum);
            System.out.println(count);
        }
    }

    private static void dfs(int start,long sum,int[] arr,int bagV,int snakeNum){
        if(sum > bagV){
            return;
        }
        if(sum <= bagV){
            count++;
        }

        for(int i = start;i<snakeNum;i++){
            dfs(i+1,sum + arr[i],arr,bagV,snakeNum);
        }
    }

    private static void sort(int[] arr){
        int temp;
        for(int i = 0;i<arr.length-1;i++){
            for(int j = i+1;j>0;j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    private static long sum(int[] arr){
        long result = 0;
        for(int i = 0;i<arr.length;i++){
            result += arr[i];
        }
        return result;
    }
}

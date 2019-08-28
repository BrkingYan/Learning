package Career._5;

import java.util.*;

public class Main3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n堆苹果
        int[] stack = new int[n];
        for(int i = 0;i<n;i++){
            stack[i] = sc.nextInt();//每堆的苹果数
        }
        int m = sc.nextInt();
        int[] queries = new int[m];
        for(int i = 0;i<m;i++){
            queries[i] = sc.nextInt();
        }
        //queries[i] 表示第queries[i]个苹果属于哪一个堆
        ArrayList<Integer> result = new ArrayList<>();
        int[] sum = new int[n];
        // sum[i] 表示前i堆有多少个苹果
        for(int i = 0;i<n;i++){
            for(int j = 0;j<=i;j++){
                sum[i] += stack[j];
            }
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(queries[i] > sum[j]){
                    result.add(j);
                    break;
                }else if(queries[i] == sum[j]){
                    result.add(j+1);
                    break;
                }
            }
        }
        for(int e : result){
            System.out.println(e);
        }
    }
}

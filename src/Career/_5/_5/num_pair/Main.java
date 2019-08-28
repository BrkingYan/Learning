package Career._5._5.num_pair;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//[1,n]
        int k = sc.nextInt();//[0,k]
        // x,y [1,n]
        long count = 0;

        if(k == 0){
            count = (long)Math.pow(n,2);
            System.out.println(count);
            return;
        }

        // y >= 2
        long loopTime = 0;
        long leftIndex = 0;
        long countEveryLoop = 0;
        long left = 0;
        for(long y = k+1;y <= n;y++){
            countEveryLoop = y - k;
            loopTime = n / y;
            leftIndex = n % y;
            if (leftIndex == 0){
                left = 0;
            }else if (leftIndex < k){
                left = 0;
            }else {
                left = leftIndex - k + 1;
            }
            count = count + countEveryLoop * loopTime + left;
        }
        System.out.println(count);
    }
}

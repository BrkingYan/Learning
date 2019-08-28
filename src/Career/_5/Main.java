package Career._5;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // slot[i] 表示第i个slot上面的方块个数
        int[] slot = new int[n];
        int[] locations = new int[m];
        //locations[i] 表示第i个方块落在那个slot

        for(int i = 0;i<m;i++){
            locations[i] = sc.nextInt();
        }

        for(int i = 0;i<n;i++){
            slot[locations[i]-1]++;
        }
        int score = findMin(slot);
        System.out.println(score);
    }

    private static int findMin(int[] arr){
        int min = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}

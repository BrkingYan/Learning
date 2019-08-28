package Career._5;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // slot[i] ��ʾ��i��slot����ķ������
        int[] slot = new int[n];
        int[] locations = new int[m];
        //locations[i] ��ʾ��i�����������Ǹ�slot

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

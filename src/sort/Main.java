package sort;

import java.util.*;
public class Main{
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,2,4,6};
        int[] temp = new int[6];
        help(arr,temp,0,5);
        for (int e : arr){
            System.out.println(e);
        }
    }

    private static long help(int[] arr,int[] temp,int start,int end){
        if(start == end){
            return 0;
        }
        int mid = (start+end)/2;
        return help(arr,temp,start,mid) + help(arr,temp,mid+1,end) + merge(arr,temp,start,mid,end);
    }

    //返回数组[start,end]的小和
    private static long merge(int[] arr,int[] temp,int start,int mid,int end){
        int leftP = start;
        int rightP = mid+1;

        for(int i = start;i<=end;i++){
            temp[i] = arr[i];
        }
       // Arrays.sort(arr,(x,y)->(y[0]-x[0]));
        long sum = 0;
        for(int k = start;k<=end;k++){
            if(rightP > end){
                arr[k] = temp[leftP++];
            }else if(leftP > mid){
                arr[k] = temp[rightP++];
            }else if(temp[leftP] < temp[rightP]){
                arr[k] = temp[leftP];
                sum += temp[leftP++]*(end-rightP+1);
            }else{
                arr[k] = temp[rightP++];
            }
        }
        return sum;
    }
}

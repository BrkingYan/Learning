import java.util.*;
/*
* 10 -2 8 -4 6 7 5
* 8 -2 -4 10 7 6 5
*
* 0 4 0 20 0 12 0
* */
public class MAi {
    private ArrayList<Integer> list = new ArrayList<>();
    private static int[] result;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] p = sc.nextLine().split(" ");
        String[] ii = sc.nextLine().split(" ");
        int len = p.length;
        int[] pre = new int[len];
        int[] in = new int[len];
        result = new int[len];
        for(int i = 0;i<len;i++){
            pre[i] = Integer.parseInt(p[i]);
            in[i] = Integer.parseInt(ii[i]);
        }
        process(pre,in,0,len-1,0,len-1);
        for(int i = 0;i<len;i++){
            System.out.print(result[i] + " ");
        }
    }

    private static void process(int[] pre,int[] in,int preS,int preE,int inS,int inE){
        int key = pre[preS];
        int fence = findIndex(in,key);
        result[fence] = sum(in,inS,inE) - key;
        if(fence > inS){
            if(preS + 1 < pre.length){
                if (preS + fence < pre.length){
                    process(pre,in,preS+1,preS+fence,0,fence-1);
                }
            }
        }
        if(fence < inE){
            process(pre,in,preS+1+fence,preE,fence+1,inE);
        }
    }

    private static int findIndex(int[] arr,int key){
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    private static int sum(int[] arr,int start,int end){
        int sum = 0;
        for(int i = start;i<end;i++){
            sum += arr[i];
        }
        return sum;
    }
}

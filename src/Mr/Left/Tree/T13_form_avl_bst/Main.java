package Mr.Left.Tree.T13_form_avl_bst;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<a.length()-1;i++){
            sb.append(a.charAt(i));
        }
        String[] aa = sb.toString().split(",");
        int len = aa.length;
        int[] arr = new int[len];
        for(int i = 0;i<len;i++){
            arr[i] = Integer.parseInt(aa[i]);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<len;i++){
            set.add(arr[i]);
        }
        int ret = 0;
        int maxRet = ret;
        int temp;
        int max;
        int min;
        for(int i = 0;i<len;i++){
            temp = arr[i];
            ret = help(temp,set);
            if(ret > maxRet){
                maxRet = ret;
            }
        }
        System.out.println(maxRet);
    }

    private static int help(int num,HashSet<Integer> set){
        int ret = 1;
        int temp = num;
        while(set.remove(temp+1)){
            temp++;
            ret++;
        }
        temp = num;
        while(set.remove(temp-1)){
            temp--;
            ret++;
        }
        return ret;
    }

}

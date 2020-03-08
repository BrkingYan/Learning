package Career._5;

import java.util.*;

public class Main3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n��ƻ��
        int[] stack = new int[n];
        for(int i = 0;i<n;i++){
            stack[i] = sc.nextInt();//ÿ�ѵ�ƻ����
        }
        int m = sc.nextInt();
        int[] queries = new int[m];
        for(int i = 0;i<m;i++){
            queries[i] = sc.nextInt();
        }
        //queries[i] ��ʾ��queries[i]��ƻ��������һ����
        ArrayList<Integer> result = new ArrayList<>();
        int[] sum = new int[n];
        // sum[i] ��ʾǰi���ж��ٸ�ƻ��
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

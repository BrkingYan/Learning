package Career._5;

import java.util.*;
public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //����С��һ��ʹ���ܹ��������ѵ�ʱ�䡣
        int k = sc.nextInt();

        //ֻ�ܽ�����һ��
        int[] interest = new int[n];
        int[] state = new int[n];
        for(int i = 0;i<n;i++){
            interest[i] = sc.nextInt();
        }

        for(int i = 0;i<n;i++){
            state[i] = sc.nextInt();
        }

        if(k >= n){
            System.out.println(sumRange(interest,0,n-1));
            return;
        }
        //define a slide window
        ArrayList<Integer> sumList = new ArrayList<>();
        for(int leftP = 0;leftP < n;leftP++){
            if (state[leftP] == 1){
                continue;
            }
            int sum = 0;
            //����֮ǰ��Ȼ�ѵ�interest
            for (int i = 0;i<leftP;i++){
                if (state[i] == 1){
                    sum += interest[i];
                }
            }
            int rightP = leftP + k - 1;
            int rightBorder;
            if(rightP < n){
                rightBorder = rightP;
            }else{
                rightBorder = n-1;
            }
            //���ϴ����ڵ�interest
            for(int j = leftP;j<=rightBorder;j++){
                sum += interest[j];
            }
            //���Ϻ�����Ȼ�ѵ�interest
            for (int j = rightBorder+1;j<n;j++){
                if (state[j] == 0){
                    break;
                }else {
                    sum += interest[j];
                }
            }
            sumList.add(sum);
        }
        int max = findMax(sumList);
        System.out.println(max);
    }

    private static int sumRange(int[] arr,int start,int end){
        int sum = 0;
        for(int i = start;i<=end;i++){
            sum += arr[i];
        }
        return sum;
    }

    private static int findMax(ArrayList<Integer> list){
        int max = list.get(0);
        for(int i = 1;i<list.size();i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        return max;
    }
}

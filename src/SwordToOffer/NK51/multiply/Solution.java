package SwordToOffer.NK51.multiply;

import java.util.ArrayList;
import java.util.List;

/*
* ����һ������A[0,1,...,n-1],
* �빹��һ������B[0,1,...,n-1],����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]��
* ����ʹ�ó�����
* */
public class Solution {
    public int[] multiply(int[] A) {
        int zeroNum = 0;
        List<Integer> zeroIndex = new ArrayList<>();

        int[] B = new int[A.length];
        for (int i = 0;i<A.length;i++){
            if (A[i]==0){
                zeroNum ++;
                zeroIndex.add(i);
            }
        }

        if (zeroNum > 1){
            //return B;
        }else if (zeroNum == 1){
            int multi = 1;
            for (int i = 0;i<A.length;i++){
                if (i != zeroIndex.get(0)){
                    multi *= A[i];
                }
            }
            B[zeroIndex.get(0)] = multi;
        }else {
            B[0] = 1;

            for (int i = 1;i<A.length;i++){
                B[0] *= A[i];
            }
            for (int i = 1;i<A.length;i++){
                B[i] = (int)(B[i-1] * ((double)A[i-1]/(double)A[i]));
            }
        }
        return B;
    }
}

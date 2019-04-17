package SwordToOffer.NK30.FindGreatestSumOfSubArray;

/*
* HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ��
* ��������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,
* ������ȫΪ������ʱ��,����ܺý��������,��������а�������,�Ƿ�Ӧ�ð���ĳ������,
* �������Աߵ��������ֲ����أ�����:{6,-3,-2,7,-15,1,2,2},
* ����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
* ��һ�����飬��������������������еĺͣ���᲻�ᱻ������ס��(�������ĳ���������1)
*
* F(i) ��array[i]ΪĩβԪ�ص�������ĺ͵����ֵ
*
* 1,-2,3,10,-4,7,2,-5
* */
class Solution {
    int FindGreatestSumOfSubArray(int[] array) {
        int current = array[0];
        for (int i = 1;i<array.length;i++){
            current = max(current,i,array);
        }
        return current;
    }

    private int max(int a,int index,int[] array){
        int sum = array[index];
        int max = sum;
        for (int i = 0;i<index;i++){
            sum += array[index-1-i];
            if (sum > max){
                max = sum;
            }
        }
        if (max>=a){
            return max;
        }
        return a;
    }
}

package SwordToOffer.NK31.NumberOf1Between1AndN_Solution;

/*
*���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����
* Ϊ�����ر�����һ��1~13�а���1��������1��10��11��12��13��˹�����6��,���Ƕ��ں�����������û���ˡ�
* ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�������1 �� n ��1���ֵĴ�������
*
* �ҳ�1--n���������ܹ�����1�ĸ���
* */
class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1;i<=n;i++){
            sb.append(i);
        }
        char[] array = sb.toString().toCharArray();
        int count = 0;
        for (int i = 0;i<array.length;i++){
            if (array[i] == '1'){
                count++;
            }
        }
        return count;
    }
}

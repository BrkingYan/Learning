package SwordToOffer.NK23.VerifySquenceOfBST;


/*
*����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
* ����������Yes,�������No���������������������������ֶ�������ͬ��
* */
class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        /*
        * ������Ϊ1��˵���Ѿ��������
        * �����Ȳ�Ϊ1���涨��ͨ�����
        * */
        if (sequence.length==1){
            return true;
        }else if (sequence.length == 0){
            return false;
        }

        //β�ڵ�
        int nodeVal = sequence[sequence.length-1];
        //�ҳ��ֽ紦���±�
        int index = 0;
        for (int i = 0;i < sequence.length-1;i++){
            if (nodeVal < sequence[i]){
                index = i-1;
                break;
            }
            //���û�ҵ���ĩβ��ģ�˵������ĩβС
            index = sequence.length-2;
        }

        //���ǰ�������Ƿ���ϣ�ǰ���ж���β�ڵ�С�������ж���β�ڵ�󣬵�Ҫ��
        for (int i = index+1;i<sequence.length-2;i++){
            if (sequence[i] < nodeVal){
                return false;
            }
        }

        //��indexΪ�磬��ǰ�����зֱ��¡������������
        int[] leftSequence = new int[index+1];
        int[] rightSequence = new int[sequence.length-index-2];
        for (int i = 0;i <= index;i++){
            leftSequence[i] = sequence[i];
        }
        for (int i = 0;i<sequence.length-index-2;i++){
            rightSequence[i] = sequence[i+index+1];
        }

        //ֻ�е����߶�Ϊ0ʱ��������Ĳ�ͨ�����
        return VerifySquenceOfBST(leftSequence) || VerifySquenceOfBST(rightSequence);
    }
}

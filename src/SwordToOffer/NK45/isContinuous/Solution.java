package SwordToOffer.NK45.isContinuous;

/*
 *LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54 ��^_^)...
 * ��������г����5 ����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
 * ������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,
 * ��������,������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
 * �����5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����
 * LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Σ�
 * ����������˳�Ӿ����true����������false��
 *
 * Ϊ�˷������,�������Ϊ��С����0��
 * */
class Solution {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length == 0){
            return false;
        }
        sort(numbers,0,numbers.length-1);
        int zeroCount = 0;
        for (int e : numbers){
            if (e == 0){
                zeroCount++;
            }
        }
        for (int i = zeroCount;i<numbers.length-1;i++){
            int minus = numbers[i+1] - numbers[i];
            if (minus-1 > zeroCount || minus==0){
                return false;
            }
            zeroCount = zeroCount-minus+1;
        }
        return true;
    }

    private void sort(int[] a, int low, int high) {
        int lPointer, rPointer, mark;
        if (low > high) {
            return;
        }
        lPointer = low;
        rPointer = high;
        mark = a[lPointer]; // ���ӱ�ĵ�һ����¼����׼
        while (lPointer < rPointer) {
            // ���������ҵ�һ��С�ڻ�׼mark����
            while (lPointer < rPointer && a[rPointer] >= mark)
                rPointer--;
            if (lPointer < rPointer)
                a[lPointer++] = a[rPointer];
            //���������ҵ�һ�����ڻ�׼mark����
            while (lPointer < rPointer && a[lPointer] < mark)
                lPointer++;
            if (lPointer < rPointer)
                a[rPointer--] = a[lPointer];
        }
        a[lPointer] = mark;// ����׼��ֵ�滻�� a[i]
        sort(a, low, lPointer - 1); // �Ե��ӱ���еݹ�����
        sort(a, lPointer + 1, high); // �Ը��ӱ���еݹ�����

    }
}

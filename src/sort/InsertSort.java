package sort;


/*
* ��������: ��Ҫ�����һ�����У��ٶ�ǰn-1�����Ѿ��ź���
* ���ڽ���n�����嵽ǰ������������У�ʹ����n����Ҳ���ź�˳��ġ���˷���ѭ����ֱ��ȫ���ź�˳��
 * ʱ�临�Ӷ�ҲΪO(n^2), ��ð�ݷ���ѡ�����������Ҫ����һЩ
 *
 * ����һ��Ԫ����ǰ���Ѿ�����õ������������
 * */
public class InsertSort {
    public static void main(String[] args) {
        int[] arrr = new int[]{3,44,38,5,47};
        insertSort(arrr);
    }

    private static void insertSort(int[] arr){
        int len = arr.length;
        int temp;
        for (int i =0 ;i<len-1;i++){
            for (int j = i+1;j>0;j--){
                //���ڽ���
                if (arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }

        for (int e : arr){
            System.out.println(e);
        }
    }
}

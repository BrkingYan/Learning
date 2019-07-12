package sort;


/*
* ѡ������ά��һ��minIndex����ʼʱָ���һ��Ԫ�أ�Ȼ������δ����ĸ�Ԫ����minIndexָ���Ԫ�رȽ�
*           �����minIndexָ���Ԫ��С������minIndexָ���С�ģ�����minIndex��ָ��δδ�������е���Сֵ
*           �������Сֵ��֮ǰ����������õ�Ԫ�ػ���
* ʱ�临�Ӷ�ҲΪO(n^2)
*
*
* */
public class SelectSort {
    public static void main(String[] args) {
        int[] arrr = new int[]{3,44,38,5,47};
        selectSort(arrr);
    }

    private static void selectSort(int[] arr){
        int len = arr.length;
        int minIndex;
        int temp;
        for (int i = 0;i<len;i++){
            minIndex = i;
            for (int j = i+1;j<len;j++){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int e:arr){
            System.out.println(e);
        }
    }

    private static void selectSortOptimization(int[] arr){
        int len = arr.length;
        int minIndex;
        boolean flag = true;
        int temp;
        while (flag){
            flag = false;
        }
        for (int i = 0;i<len;i++){
            minIndex = i;
            for (int j = i+1;j<len;j++){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int e:arr){
            System.out.println(e);
        }
    }
}

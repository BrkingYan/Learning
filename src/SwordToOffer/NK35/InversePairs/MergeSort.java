package SwordToOffer.NK35.InversePairs;

public class MergeSort {

    void beginMergeSort(int[] array){
        int[] temp = new int[array.length];
        sort(array,0,array.length-1,temp);
    }

    private void sort(int[] array,int leftStart,int rightEnd,int[] temp){
        if (leftStart < rightEnd){
            int mid = (leftStart + rightEnd) / 2;
            sort(array,leftStart,mid,temp);
            sort(array,mid+1,rightEnd,temp);
            merge(array,leftStart,mid,rightEnd,temp);
        }
    }

    private void merge(int[] array,int leftStart,int mid,int rightEnd,int[] temp){
        int lPointer = leftStart;
        int rPointer = mid+1;
        int tPointer = 0;
        while (lPointer <= mid && rPointer <= rightEnd){
            if (array[lPointer] <= array[rPointer]){
                temp[tPointer++] = array[lPointer++];
            }else {
                temp[tPointer++] = array[rPointer++];
            }
        }

        while (lPointer <= mid){ //�����ʣ��Ԫ������temp��
            temp[tPointer++] = array[lPointer++];
        }
        while (rPointer <= rightEnd){ //��������ʣ��Ԫ������temp��
            temp[tPointer++] = array[rPointer++];
        }
        tPointer = 0;
        //����ǰtemp�е�����Ԫ��ȫ��������ԭ����ָ��λ��
        while (leftStart <= rightEnd){
            array[leftStart++] = temp[tPointer++];
        }
    }
}

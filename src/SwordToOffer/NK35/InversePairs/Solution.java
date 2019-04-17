package SwordToOffer.NK35.InversePairs;

/*
*   �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
*   ����һ������,�����������е�����Ե�����P������P��1000000007ȡģ�Ľ������� �����P%1000000007
*
*   ��Ŀ��֤�����������û�е���ͬ������
*   ���ݷ�Χ��
*
*   ����%50������,size<=10^4
*   ����%75������,size<=10^5
*   ����%100������,size<=2*10^5
*
*   ���룺1,2,3,4,5,6,7,0
*   �����7
*
*   4,3,6,1,2,5
* */
class Solution {
    private static int count = 0;
    int InversePairs(int [] array) {
        if (array.length == 0){
            return 0;
        }
        begin(array);
        return count;
    }

    private void begin(int[] array){
        int[] temp = new int[array.length];
        sort(array,0,array.length-1,temp);
    }

    private void sort(int[] array,int leftStart,int rightEnd,int[] temp){
        if (leftStart < rightEnd){
            int mid = (leftStart + rightEnd) / 2;
            sort(array,leftStart,mid,temp);
            sort(array,mid+1,rightEnd,temp);
            mergeAndCount(array,leftStart,rightEnd,mid,temp);
        }
    }

    private void mergeAndCount(int[] array,int leftStart,int rightEnd,int mid,int[] temp){
        int lPointer = leftStart;
        int rPointer = mid+1;
        int tPointer = 0;
        //sort
        while (lPointer <= mid && rPointer <= rightEnd){
            if (array[lPointer] <= array[rPointer]){
                temp[tPointer++] = array[lPointer++];
            }else {
                temp[tPointer++] = array[rPointer++];
                count += (mid-lPointer+1);
                if (count >= 1000000007){
                    count = count % 1000000007;
                }
            }
        }

        while (lPointer <= mid){
            temp[tPointer++] = array[lPointer++];
        }
        while (rPointer <= rightEnd){
            temp[tPointer++] = array[rPointer++];
        }
        tPointer = 0;
        //����ǰtemp�е�����Ԫ��ȫ��������ԭ����ָ��λ��
        while (leftStart <= rightEnd){
            array[leftStart++] = temp[tPointer++];
        }
    }
}

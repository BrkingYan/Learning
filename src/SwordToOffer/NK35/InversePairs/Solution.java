package SwordToOffer.NK35.InversePairs;

/*
*   在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
*   输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
*
*   题目保证输入的数组中没有的相同的数字
*   数据范围：
*
*   对于%50的数据,size<=10^4
*   对于%75的数据,size<=10^5
*   对于%100的数据,size<=2*10^5
*
*   输入：1,2,3,4,5,6,7,0
*   输出：7
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
        //将当前temp中的所有元素全部拷贝到原数组指定位置
        while (leftStart <= rightEnd){
            array[leftStart++] = temp[tPointer++];
        }
    }
}

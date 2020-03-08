package sort;


import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

/*
* ��ȫ�������������������Ӽ�����ȫ����������ź�����������Ӧ
*
* ���Ǿ����������ʵ���ȫ��������
* �󶥶ѣ�ÿ������ֵ�����ڻ���������Һ��ӽ���ֵ
* С���ѣ�ÿ������ֵ��С�ڻ���������Һ��ӽ���ֵ
*
* �����ã�ƽ��ʱ�临�ӶȾ�ΪO(nlogn) �� ���ȶ�����
* ���裺
* 1���ӵ�һ����Ҷ�ӽڵ㿪ʼ���������Ͻ��е���������������γɴ󶥶�
* 2�����Ͻ�ͷβ������ÿ�λ����󶼵���һ�Σ�������С��Χ�����ʵ������
*
* */
public class HeapSort {
    public static void main(String[] args) {
        int[] arrr = new int[]{3,44,38,5,47,7,7};
        heapSort(arrr);
        for (int e : arrr){
            System.out.println(e);
        }
    }

    private static void heapSort(int[] arr){
        //�����󶥶ѣ��Ӻ���ǰ������һ����Ҷ�ӽڵ㿪ʼ
        int start = arr.length / 2 - 1;
        while (start >= 0){
            sink(arr,start,arr.length);
            start--;
        }

        //ÿ����һ�δ󶥶ѣ��Ѷ�Ԫ�ؾ�������
        //���Ͻ��Ѷ�Ԫ�طŵ�ĩβ�������¹����󶥶�
        for (int j = arr.length-1;j>0;j--){
            swap(arr,0,j);//���Ѷ�Ԫ�غ�ĩβԪ�ػ���
            sink(arr,0,j);//������С��Χ
        }
    }

    private static void heapSort2(int[] arr){
        //�����󶥶ѣ��Ӻ���ǰ������һ����Ҷ�ӽڵ㿪ʼ
        int start = arr.length / 2 - 1;
        while (start >= 0){
            floatUp(arr,start,arr.length);
            start--;
        }

        //���Ͻ��Ѷ�Ԫ�طŵ�ĩβ�������¹����󶥶�
        for (int j = arr.length-1;j>0;j--){
            swap(arr,0,j);//���Ѷ�Ԫ�غ�ĩβԪ�ػ���
            floatUp(arr,0,j);//������С��Χ
        }
    }

    //��i-N��Χ�ڵĽڵ����Ϊ�󶥶ѣ���ʱi��Ϊ���ϣ�N��Ϊ����

    /*
    * ���Ĺ���ԭ���ǣ�
    * 1�������������󶥶�����(ֻ�жѶ���ĩβԪ�ز�����)
    *       �÷������ܱ�֤������(i,N-1)�����Ǵ󶥶�
    *       ��������£��÷�����������
    * 2���������������󶥶�����
    *       �÷�����ֻ�ܱ�֤ i��i+1��i+2 ����Ԫ������󶥶�����
    *       ��������£��÷������ڹ����󶥶�
    * */

    /*
    * �÷�����֤arr[1] �� arr[N]��Ԫ��������󶥶ѵ�
    * */
    private static void sink(int[] arr,int i,int N){
        int childIndex = 2 * i + 1;//left child
        int parent = arr[i];
        while (childIndex < N){
            if (childIndex + 1 < N && arr[childIndex] < arr[childIndex + 1]){
                childIndex++;
            }

            if (arr[childIndex] > parent){
                arr[i] = arr[childIndex];
                i = childIndex;
            }else {
                break;
            }
            childIndex = 2 * childIndex + 1;
        }
        arr[i] = parent;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * �÷�����֤ arr�� i �� N �ķ�Χ����С����
     * */
    private static void floatUp(int[] arr,int i,int N){
        int parent = arr[i];
        int childIndex = 2 * i + 1;
        while (childIndex < N){
            if (childIndex+1 < N && arr[childIndex] > arr[childIndex+1]){
                childIndex++;
            }
            if (arr[childIndex] < parent){
                arr[i] = arr[childIndex];
                i = childIndex;
            }else {
                break;
            }
            childIndex = 2 * childIndex + 1;
        }
        arr[i] = parent;
    }
}

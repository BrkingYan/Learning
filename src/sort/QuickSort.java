package sort;


import java.util.LinkedList;
import java.util.List;
import edu.princeton.cs.algs4.*;
/*
* ��������
*
* �ڿ��������ʼ������0-4��������С����
* */
public class QuickSort {
    public static void main(String[] args) {
        int[] arrr = new int[]{4,19,14,5,-3,1,8,5,11,15};
        quickSort(arrr,0,arrr.length-1);

        for (int e: arrr){
            System.out.println(e);
        }
    }

    /*
    * �����˼�룺����ǰ�����з֣�Ȼ��ֱ����������ֽ�������
    *             ���зֵ�ֻʣһ��Ԫ��ʱ��ֱ�ӷ���(ֻ��һ��Ԫ���ǲ����зֵ�)
    *             ���зֵ�ֻʣ����Ԫ��ʱ�������з�
    * */
    private static void quickSort(int[] arr,int start,int end){
        System.out.println("begin sort "+ start + "--" + end);
        //���end  == start��˵��ֻ��һ��Ԫ�أ���ֱ�ӷ���
        if (end <= start){
            System.out.println("end sort " + start + "--" + end);
            return;
        }
        int mid = partition(arr,start,end);
        quickSort(arr,start,mid-1);
        quickSort(arr,mid+1,end);
        System.out.println("end sort " + start + "--" + end);
    }

    /*
    *  �ú�����������һ���м�ֵ(����ĵ�һ��Ԫ��)�з�Ϊ���룬ǰһ���Ԫ�ض�С���м�ֵ����һ���Ԫ�ض������м�ֵ
    * */
    private static int partition(int[] arr,int start,int end){
        System.out.println("begin partition " + start + "--" + end);
        int leftPointer = start+1;

        int rightPointer = end;
        int temp;
        int key = arr[start];//�Ե�һ��Ԫ��Ϊkey

        while (true){
            //leftPointerɨ���ķ�Χ��������keyС
            //һֱ��Ѱ����key���ֵ���������һ��Ԫ��Ϊֹ
            while (arr[leftPointer] < key){
                if (leftPointer == end)
                    break;//��ĩβ���˳�
                //�������������
                leftPointer++;
            }
            //rightPointerɨ���ķ�Χ��������key��
            //һֱ��Ѱ����keyС��ֵ���ߵ�һ��Ԫ��
            while (arr[rightPointer] > key){
                if (rightPointer == start)
                    break;//����ǰ�˾��˳�
                //���������ǰ��
                rightPointer--;
            }

            if (leftPointer >= rightPointer){//�������ָ�뻮���ķ�Χ���ڽ�������ʱ��ָ��һ������
                //midIndex = rightPointer;//��ô���ĵ������ָ���λ��
                //��ʱ������з���ȫ�ɹ���
                break;
            }
            //����Ļ���˵����û�з���ȫ������ָ�뻹����Զ��
            //��ˣ�����ָ��ָ������ݻ���������ִ������Ĳ�����
            temp = arr[rightPointer];
            arr[rightPointer] = arr[leftPointer];
            arr[leftPointer] = temp;
        }
        /*
        * ��start��rightIndex����
        * */
        temp = arr[start];
        arr[start] = arr[rightPointer];
        arr[rightPointer] = temp;
        //swap(arr[start],arr[rightPointer]);
        System.out.println("end partition " + start + "--" + end);
        return rightPointer;
    }

    private static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }
}

package sort;


import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

/*
* 完全二叉树是满二叉树的子集，完全二叉树的序号和满二叉树对应
*
* 堆是具有以下性质的完全二叉树：
* 大顶堆：每个结点的值都大于或等于其左右孩子结点的值
* 小顶堆：每个结点的值都小于或等于其左右孩子结点的值
*
* 最坏，最好，平均时间复杂度均为O(nlogn) ， 不稳定排序
* 步骤：
* 1、从第一个非叶子节点开始，不断往上进行调整，最后将整个树形成大顶堆
* 2、不断将头尾互换，每次互换后都调整一次，慢慢缩小范围，最后实现排序
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
        //构建大顶堆，从后往前数，第一个非叶子节点开始
        int start = arr.length / 2 - 1;
        while (start >= 0){
            sink(arr,start,arr.length);
            start--;
        }

        //每构建一次大顶堆，堆顶元素就是最大的
        //不断将堆顶元素放到末尾，并重新构建大顶堆
        for (int j = arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素和末尾元素互换
            sink(arr,0,j);//不断缩小范围
        }
    }

    private static void heapSort2(int[] arr){
        //构建大顶堆，从后往前数，第一个非叶子节点开始
        int start = arr.length / 2 - 1;
        while (start >= 0){
            floatUp(arr,start,arr.length);
            start--;
        }

        //不断将堆顶元素放到末尾，并重新构建大顶堆
        for (int j = arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素和末尾元素互换
            floatUp(arr,0,j);//不断缩小范围
        }
    }

    //将i-N范围内的节点调整为大顶堆，此时i处为最上，N处为最下

    /*
    * 它的工作原理是：
    * 1、如果子树满足大顶堆条件(只有堆顶和末尾元素不满足)
    *       该方法就能保证结束后，(i,N-1)子树是大顶堆
    *       这种情况下，该方法用于排序
    * 2、如果子树不满足大顶堆条件
    *       该方法就只能保证 i，i+1，i+2 三个元素满足大顶堆条件
    *       这种情况下，该方法用于构建大顶堆
    * */

    /*
    * 该方法保证arr[1] 到 arr[N]的元素是满足大顶堆的
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
     * 该方法保证 arr中 i 到 N 的范围内是小顶堆
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

package sort;


/*
* ��ȫ�������������������Ӽ�����ȫ����������ź�����������Ӧ
*
* ���Ǿ����������ʵ���ȫ��������
* �󶥶ѣ�ÿ������ֵ�����ڻ���������Һ��ӽ���ֵ
* С���ѣ�ÿ������ֵ��С�ڻ���������Һ��ӽ���ֵ
*
* �����ã�ƽ��ʱ�临�ӶȾ�ΪO(nlogn) �� ���ȶ�����
*
* ���裺
* 1���ӵ�һ����Ҷ�ӽڵ㿪ʼ���������Ͻ��е���������������γɴ󶥶�
* 2�����Ͻ�ͷβ������ÿ�λ����󶼵���һ�Σ�������С��Χ�����ʵ������
*
*
* */
public class HeapSort {
    public static void main(String[] args) {
        int[] arrr = new int[]{3,44,38,5,47};
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

        //���Ͻ��Ѷ�Ԫ�طŵ�ĩβ�������¹����󶥶�
        for (int j = arr.length-1;j>0;j--){
            swap(arr,0,j);//���Ѷ�Ԫ�غ�ĩβԪ�ػ���
            sink(arr,0,j);//������С��Χ
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
    private static void ensureBigHeap(int[] arr,int headIndex,int N){
        int currentMaxVal = arr[headIndex];// currentMaxVal���ڱ��浱ǰ���ֵ���ʼ����i����ֵ
        int child;//�±�k���ڱ������е���ڵ㣬����ʼΪ2*i+1����i����ڵ㣬k=k*2+1����������ڵ�
        for (child = 2*headIndex+1;child<N;child=child*2+1){
            if (child+1 < N && arr[child] < arr[child+1]){//�����ҽڵ㶼���ڣ�������ڵ�С���ҽڵ�
                child = child+1;//��ָ���ҽڵ�
                //����ִ�н�����child�������ҽڵ�Ԫ���д��ߵ��±꣬������ӽڵ���±�
            }
            //��ʱchild�������ҽڵ��е�����ߵ��±�
            if (arr[child] > currentMaxVal){//���childָ���Ԫ�ش��ڶ���Ԫ��currentMaxVal
                arr[headIndex] = arr[child];//�ͽ���ŵ�����
                headIndex = child;//�����Ԫ�ص��±궨Ϊchild
            }else {//������ҽڵ㶼С�ڶ���Ԫ��temp
                break;//����ѭ������Ϊ����ӽڵ㶼�ȸ��ڵ�С�Ļ����Ͳ��ᷢ��������Ҳ�Ͳ����ú������
            }
        }
        arr[headIndex] = currentMaxVal;
    }

    /*
    * �÷�����֤arr[1] �� arr[N]��Ԫ��������󶥶ѵ�
    * */
    private static void sink(int[] arr,int i,int N){
        int childIndex = 2 * i + 1;
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
    }


    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

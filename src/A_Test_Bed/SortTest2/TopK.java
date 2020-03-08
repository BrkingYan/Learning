package A_Test_Bed.SortTest2;

public class TopK {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,7,2,4,6,3};

        //test for heap topK max
        int[] res = topKMax(arr,3);
        for (int e : res){
            System.out.println(e);
        }

        System.out.println("*****************************");

        //test for heap topK min
        int[] res2 = topKMin(arr,3);
        for (int e : res2){
            System.out.println(e);
        }

        System.out.println("*****************************");

        //test for heap topK min
        int[] res3 = topKMinForQuick(arr,0,arr.length-1,4);
        for (int e : res3){
            System.out.println(e);
        }

        System.out.println("*****************************");
        //test for heap topK max
        int[] res4 = topKMaxForQuick(arr,0,arr.length-1,2);
        for (int e : res4){
            System.out.println(e);
        }
    }

    /****************************���ڶ������topK****************************/
    /*
    * �ҳ�����������k��Ԫ��
    * */
    private static int[] topKMax(int[] arr,int k){

        //��arr����Ϊ�󶥶�
        int start = arr.length / 2 - 1;
        while (start >= 0){
            adjustToMaxHeap(arr,start,arr.length);
            start--;
        }

        int[] res = new int[k];
        //�����ֵ����������
        for (int i = 0;i<k;i++){
            res[i] = arr[0];//ÿ�ζ���arr[0]��res����Ϊarr[0]���ǵ�ǰ���ֵ
            swap(arr,0,arr.length-1-i);//��arr�����ֵ�������Ѷ�
            adjustToMaxHeap(arr,0,arr.length-i-1);//���µ���Ϊ�󶥶�
        }
        return res;
    }

    /*
     * ��arr[i--N]����Ϊ�󶥶�
     * */
    private static void adjustToMaxHeap(int[] arr,int i,int N){
        int parent = arr[i];
        int childIndex = 2 * i + 1;
        while (childIndex < N){
            if (childIndex+1 < N && arr[childIndex+1] > arr[childIndex]){
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

    /*
     * �ҳ���������С��k��Ԫ��
     * */
    private static int[] topKMin(int[] arr,int k){

        //��arr����ΪС����
        int start = arr.length / 2 - 1;
        while (start >= 0){
            adjustToMinHeap(arr,start,arr.length);
            start--;
        }

        int[] res = new int[k];
        //����Сֵ����������
        for (int i = 0;i<k;i++){
            res[i] = arr[0];//ÿ�ζ���arr[0]��res����Ϊarr[0]���ǵ�ǰ��Сֵ
            swap(arr,0,arr.length-1-i);//��arr�����ֵ�������Ѷ�
            adjustToMinHeap(arr,0,arr.length-i-1);//���µ���ΪС����
        }
        return res;
    }

    /*
    * ��arr[i--N]����ΪС����
    * */
    private static void adjustToMinHeap(int[] arr,int i,int N){
        int parent = arr[i];
        int childIndex = 2 * i + 1;
        while (childIndex < N){
            if (childIndex+1 < N && arr[childIndex+1] < arr[childIndex]){
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
    /****************************���ڶ������topK****************************/

    /****************************���ڿ��ŵ�topK****************************/

    /*
    * topK for quick sort min
    * */
    private static int[] topKMinForQuick(int[] arr,int start,int end,int k){
        int mid = partition(arr,start,end);
        if (mid == k-1){
            int[] res = new int[k];
            for (int i = 0;i<k;i++){
                res[i] = arr[i];
            }
            return res;
        }else if (mid > k-1){
            return topKMinForQuick(arr,start,mid-1,k);
        }else {
            return topKMinForQuick(arr,mid+1,end,k);
        }
    }

    /*
     * topK for quick sort max
     * */
    private static int[] topKMaxForQuick(int[] arr,int start,int end,int k){
        int mid = partition(arr,start,end);
        if (mid == arr.length-k){
            int[] res = new int[k];
            for (int i = 0;i<k;i++){
                res[i] = arr[arr.length-i-1];
            }
            return res;
        }else if (mid > arr.length-k){
            return topKMaxForQuick(arr,start,mid-1,k);
        }else {
            return topKMaxForQuick(arr,mid+1,end,k);
        }
    }

    /*
    * �зֺ���
    * */
    private static int partition(int[] arr,int lo,int hi){
        int key = arr[lo];
        int leftP = lo+1;
        int rightP = hi;

        while (true){
            while (arr[leftP] < key){
                if (leftP == hi){
                    break;
                }
                leftP++;
            }

            while (arr[rightP] > key){
                if (rightP == lo){
                    break;
                }
                rightP--;
            }

            if (leftP >= rightP){
                break;
            }

            swap(arr,leftP,rightP);
        }
        swap(arr,lo,rightP);
        return rightP;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

package search;

public class Dictionary {
    private int[] keys;
    private String[] values;
    private int N;


    public Dictionary(int cap){
        keys = new int[cap];
        values = new String[cap];
    }

    public int size(){
        return N;
    }

    public String get(int key){
        if (isEmpty()){
            return null;
        }
        int rank = rank(keys,key,0,N);
        if (rank < N && compare(keys[rank],key)==0){
            return values[rank];
        }else {
            return null;
        }
    }

    public void put(int key,String val){
        int keyRank = rank(keys,key,0,N);
        if (keyRank < N && compare(keys[keyRank],key)==0){
            values[keyRank] = val;
            return;
        }
        for (int j = N;j > keyRank;j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[keyRank] = key;
        values[keyRank] = val;
        N++;
    }

    public boolean isEmpty(){
        return N==0;
    }

    //该方法用于计算key在arr中的排名，就算key不在arr中，也计算排名，arr是有序数组
    private static int rank(int[] arr,int key,int lo,int hi){
        int mid;
        int compareResult;
        while (lo <= hi){
            mid = (lo + hi) / 2;
            compareResult = compare(key,arr[mid]);
            if (compareResult < 0){// key < [mid]
                hi = mid - 1;
            }else if (compareResult > 0){
                lo = mid + 1;
            }else {
                return mid;
            }
        }
        return lo;
    }

    private static int compare(int a,int b){
        if (a == b){
            return 0;
        }else if (a > b){
            return 1;
        }else {
            return -1;
        }
    }
}

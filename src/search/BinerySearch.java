package search;

class BinerySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,6,8,12};
        //System.out.println(binerySearch(arr,6,1,4));
        //System.out.println(binaryRe(arr,6,0,4));
        System.out.println(rankRe(arr,3,0,4));
    }

    private static int binerySearch(int[] arr,int key,int lo,int hi){
        int mid;
        while (lo <= hi){
            mid = (lo + hi) / 2;
            if (key == arr[mid]){
                return mid;
            }else if (key > arr[mid]){
                lo = mid+1;
            }else {
                hi = mid-1;
            }
        }
        return -1;
    }

    private static int binaryRe(int[] arr,int key,int lo,int hi){
        if (lo == hi){
            if (key == arr[lo]){
                return lo;
            }else {
                return -1;
            }
        }
        int mid = 0;
        mid = (lo + hi) / 2;
        if (key == arr[mid]){
            return mid;
        }else if (key > arr[mid]){
            return binaryRe(arr,key,mid+1,hi);
        }else {
            return binaryRe(arr,key,lo,mid-1);
        }
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

    private static int rankRe(int[] arr,int key,int lo,int hi){
        if (lo > hi){
            return lo;
        }
        int mid = (lo + hi) / 2;
        int compareResult = compare(key,arr[mid]);
        if (compareResult < 0){
            return rankRe(arr,key,lo,mid-1);
        }else if (compareResult > 0){
            return rankRe(arr,key,mid+1,hi);
        }else {
            return mid;
        }
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
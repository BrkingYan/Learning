package search.Testbed;

public class Search {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,6,7,9};
        System.out.println(search(arr,4));

        System.out.println("abc".compareTo("bcf"));
    }

    private static int search(int[] arr,int target){
        int lo = 0;
        int hi = arr.length-1;
        int mid;
        while (lo < hi){
            mid = lo + (hi - lo) / 2;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] < target){
                lo = mid + 1;
            }else if (arr[mid] > target){
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static boolean searchForMat(int[] mat, int rows, int columns, int target) {
        boolean found = false;
        if(mat != null && rows > 0 && columns > 0) {
            int i = 0;
            int j = columns - 1;
            while(i < rows && j >= 0) {
                if (mat[i * columns + j] == target) {
                    found = true;
                    break;
                } else if (mat[i * columns + j] > target)
                    --j;
                else
                    ++i;
            }
        }
        return found;
    }


}

package String_Algorithm.SearchSubString;

public class Violence {
    public static void main(String[] args) {

    }

    private int search(String sub,String parent){
        int M = sub.length();
        int N = parent.length();
        int j;
        for (int i = 0;i<=N-M;i++){
            for (j = 0;j<M;j++){
                if (parent.charAt(i+j) != sub.charAt(j)){
                    break;
                }
            }
            if (j == M){
                return i;
            }
        }
        return -1;
    }
}

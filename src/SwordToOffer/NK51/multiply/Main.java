package SwordToOffer.NK51.multiply;

import java.nio.channels.SocketChannel;

public class Main {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,0,4,5};
        Solution s = new Solution();
        int[] B = s.multiply(A);
        for (int e : B){
            System.out.println(e);
        }

        double b = ((double)1 / (double)2) ;
        System.out.println(b);
    }
}

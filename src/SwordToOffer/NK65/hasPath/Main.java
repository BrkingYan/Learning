package SwordToOffer.NK65.hasPath;

import java.nio.channels.SocketChannel;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[] mat = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] str = "SLHECCEIDEJFGGFIE".toCharArray();
        System.out.println(s.hasPath(mat,5,8,str));
    }
}

package LeetCode.LeetCode2.NK2;

import java.nio.channels.SocketChannel;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] ss = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(s.evalRPN(ss));

        BackToIn b = new BackToIn();
        System.out.println(b.backToIn(ss));
    }


}

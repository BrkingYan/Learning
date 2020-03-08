package SwordToOffer.NK21.IsPopOrder;

import java.util.*;

class Solution2 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        LinkedList<Integer> stack = new LinkedList<>();
        int pushPointer = 0;
        int popPointer = 0;
        int len = pushA.length;

        for (int i = 0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[popPointer]){
                stack.pop();
                popPointer++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{4,3,5,1,2};
        System.out.println(s.IsPopOrder(a,b));
    }
}

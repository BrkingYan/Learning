package SwordToOffer.NK11.NumberOf1;

//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
public class Solution2 {
    public int NumberOf1(int n) {
        if (n == 0 || n == 1){
            return n;
        }else if (n > 0){
            return getCount(n);
        }else {
            if (n == Integer.MIN_VALUE){
                return 1;
            }else {
                return 32-getCount(-n-1);
            }
        }
    }

    private int getCount(int n){
        int count = 0;
        int temp;
        if (n == 1 || n == 0){
            return n;
        }
        while (n > 1){
            if ((temp = n % 2) == 1){
                count ++;
            }
            n = n / 2;
        }
        return count + 1;
    }
}

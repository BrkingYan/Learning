package SwordToOffer.NK10.RectCover;

/*
* 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
* 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
* */
public class Solution {
    public int RectCover(int target) {
        int result = 0;
        if (target <= 2){
            result = target;
        }else {
            result = RectCover(target - 1) + RectCover(target - 2);
        }
        return result;
    }
}

package SwordToOffer.NK33.GetUglyNumber_Solution;


/*
*  把只包含质因子2、3和5的数称作丑数（Ugly Number）。
*  例如6、8都是丑数，但14不是，因为它包含质因子7。
*  习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
* */
class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index == 1){
            return 1;
        }
        int count = 1;
        int currentNum = 2;
        while (count < index){
            int current = currentNum;
            while (current % 2 == 0){
                current = current / 2;
            }
            while (current % 5 == 0){
                current = current / 5;
            }
            while (current % 3 == 0){
                current = current / 3;
            }
            if (current == 1){
                count++;
            }
            if (count < index){
                currentNum++;
            }
        }

        return currentNum;
    }
}

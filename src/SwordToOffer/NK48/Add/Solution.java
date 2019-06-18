package SwordToOffer.NK48.Add;

/*
* 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
* */
class Solution {
    public int Add(int num1,int num2) {
        int temp = 1;


        int count = 0;
        while (true){
            if ((int) Math.pow(2,count) == temp){
                break;
            }
            count++;
        }
        return count;
    }
}

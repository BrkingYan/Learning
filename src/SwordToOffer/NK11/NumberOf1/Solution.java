package SwordToOffer.NK11.NumberOf1;


import java.util.ArrayList;
import java.util.List;

/*
* 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
* */
class Solution {
    public int NumberOf1(int n) {
        List list = new ArrayList<>();
        List fanmaList;
        int num = 0;
        if (n >= 0){
            list = NumberOf1ForPositiveNum(n);
            for (int i = 0;i < list.size();i++){
                if ((int)list.get(i) == 1){
                    num++;
                }
            }
        }else {
            if (n == -2147483648){
                num = 1;
            }else {
                list = NumberOf1ForPositiveNum(-n);
                int length = list.size();
                //补零
                for (int i = 0;i < 32-length;i++){
                    list.add(0);
                }
                //从低位到第二高位取反
                for (int i = 0;i < list.size() - 1;i++){
                    if ((int)list.get(i) == 0){
                        list.set(i,1);
                    }else {
                        list.set(i,0);
                    }
                }
                //将取反后的二进制数变成十进制
                int tempNumber = 0;
                for (int i = 0;i<list.size() - 1;i++){
                    tempNumber += (int)list.get(i) * Math.pow(2,i);
                }
                //将该十进制数加1
                tempNumber += 1;
                //计算加1后的十进制数的二进制表示中1的个数
                List finalList = NumberOf1ForPositiveNum(tempNumber);
                for (int i = 0;i < finalList.size();i++){
                    if ((int)finalList.get(i) == 1){
                        num++;
                    }
                }
                num++;
            }
        }
        return num;
    }
    public List NumberOf1ForPositiveNum(int n){
        List list = new ArrayList<>();
        while (n >= 1){
            if (n % 2 == 1){
                list.add(1);
            }else {
                list.add(0);
            }
            n = n / 2;
        }
        return  list;
    }
}

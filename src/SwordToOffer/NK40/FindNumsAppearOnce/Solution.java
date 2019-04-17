package SwordToOffer.NK40.FindNumsAppearOnce;

import java.util.ArrayList;
import java.util.List;

/*
*一个整型数组里除了两个数字之外，其他的数字都出现了两次。
* 请写程序找出这两个只出现一次的数字。
*
*  num1,num2分别为长度为1的数组。传出参数
*  将num1[0],num2[0]设置为返回结果
*
*  异或运算的性质：任何一个数字异或它自己都等于0
*
*  找到第一个为1 的位的位置,以第N 位是不是1 为标准
 * */
class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp = 0;
        for (int e : array){
            temp ^= e;
        }

        int location = findFirstLocationOf1(temp);
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        for (int i = 0;i<array.length;i++){
            if (is1OnLocationX(array[i],location)){
                first.add(array[i]);
            }else {
                second.add(array[i]);
            }
        }

        int n1 = 0;
        int n2 = 0;
        for (int i : first){
            n1 ^= i;
        }
        for (int i : second){
            n2 ^= i;
        }

        num1[0] = n1;
        num2[0] = n2;
    }

    private int findFirstLocationOf1(int num){
        String binary = Integer.toBinaryString(num);
        char[] chars = binary.toCharArray();
        for (int i = chars.length-1;i>=0;i--){
            if (chars[i] == '1'){
                return chars.length-i-1;
            }
        }
        return 0;
    }

    private boolean is1OnLocationX(int num,int x){
        String binary = Integer.toBinaryString(num);
        char[] chars = binary.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = chars.length-1;i>=0;i--){
            list.add(chars[i]);
        }

        if (list.size() < 32){
            for (int i = 0;i<32-chars.length;i++){
                list.add('0');
            }
        }
        if (list.get(x) == '1')
            return true;
        return false;
    }
}

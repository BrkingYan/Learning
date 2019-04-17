package SwordToOffer.NK40.FindNumsAppearOnce;

import java.util.ArrayList;
import java.util.List;

/*
*һ�����������������������֮�⣬���������ֶ����������Ρ�
* ��д�����ҳ�������ֻ����һ�ε����֡�
*
*  num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
*  ��num1[0],num2[0]����Ϊ���ؽ��
*
*  �����������ʣ��κ�һ������������Լ�������0
*
*  �ҵ���һ��Ϊ1 ��λ��λ��,�Ե�N λ�ǲ���1 Ϊ��׼
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

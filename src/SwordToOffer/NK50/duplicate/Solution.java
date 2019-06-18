package SwordToOffer.NK50.duplicate;


import Design_Patterns.NO6_Command_Mode.Light;

import java.util.ArrayList;
import java.util.List;

/*
* ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ�
* ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
* Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
* ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2
*
* // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
*
* */
public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        List<Integer> list = new ArrayList<>();
        if (numbers.length == 0){
            return false;
        }
        Loop:
        for (int i = 0;i<numbers.length;i++){
            for (int j = i+1;j<numbers.length;j++){
                if (numbers[i] == numbers[j]){
                    list.add(numbers[i]);
                    duplication[0] = numbers[i];
                    break Loop;
                }
            }
        }
        System.out.println(list);
        if (!list.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}

package SwordToOffer.NK7.fabulaci;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int Fibonacci(int n) {
        if (n < 0){
            return -1;
        }else if (n < 2){
            return n;
        }else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }

    public int Fibonacci2(int n) {
        List<Integer> list = new ArrayList<>();
        int currentNum;
        if (n < 0){
            throw new IndexOutOfBoundsException("没有该下标");
        }else if (n < 2){
            return n;
        }else {
            list.add(0);
            list.add(1);
            for (int i = 0;i<n;i++){
                currentNum = list.get(i) + list.get(i+1);
                list.add(currentNum);
            }
            return list.get(list.size() - 1);
        }

    }
}

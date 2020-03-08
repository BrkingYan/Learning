package myTestBed;

import Design_Patterns2.generate_instance.AbstractFactoryPattern.AbstractFactory.Link;

import java.util.*;
class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(permute(arr));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> total = new ArrayList<>();
        for(int e : nums){
            list.add(e);
        }
        backTrack(0,list.size(),list,total);
        return total;
    }

    private static void backTrack(int start,int n,List<Integer> list,List<List<Integer>> total){
        if(start == n){
            total.add(new ArrayList(list));
            return;
        }
        for(int i = start;i<n;i++){
            Collections.swap(list,start,i);
            backTrack(start+1,n,list,total);
            Collections.swap(list,start,i);
        }
    }
}

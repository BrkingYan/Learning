package MI_OJ.NO2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        LinkedList<String> list = new LinkedList<>();
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String[] nums = line.split(" ");
            for (int i = 0;i<nums.length;i++){
                if (list.isEmpty()){
                    list.add(nums[i]);
                }else {
                    if (list.contains(nums[i])){
                        list.remove(nums[i]);
                    }else {
                        list.add(nums[i]);
                    }
                }
            }
            System.out.println(list.get(0));
        }
    }
}


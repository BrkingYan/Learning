package MI_OJ.Match.Match1;

import ThinkingInJava.HouQiBangDing.Test;

import java.util.*;

public class Test1 {
    private class Num implements Comparable<Num >{
        int val;
        int yinZi;
        Num(int val,int yinZi){
            this.val = val;
            this.yinZi = yinZi;
        }

        @Override
        public int compareTo(Num o) {
            if (this.yinZi > o.yinZi){
                return 1;
            }else if (this.yinZi < o.yinZi){
                return -1;
            }else {
                if (this.val > o.val){
                    return 1;
                }else if (this.val < o.val){
                    return -1;
                }else {
                    return 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] strings = line.split(" ");
            List<Num> list = new ArrayList<>();
            int k = Integer.parseInt(strings[0]);
            Test1 t = new Test1();
            t.addNumToList(list,strings);
            Collections.sort(list);
            System.out.println(list.get(k-1));
            // System.out.println("answer");
        }
    }

    private void addNumToList(List<Num> list,String[] strings){
        for (int i = 1;i<strings.length;i++){
            int v = Integer.parseInt(strings[i]);
            Num num = new Num(v,calYinZi(v));
            list.add(num);
        }
    }
    private int calYinZi(int num){
        int count = 0;
        for (int i = 1;i<=num;i++){
            if (num % i == 0 ){
                count++;
            }
        }
        return count;
    }
}


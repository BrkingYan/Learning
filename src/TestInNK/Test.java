package TestInNK;

import java.util.*;

public class Test {
    public static void main(String[] args){
        ArrayList<Integer> bulbNumList = new ArrayList<>();
        ArrayList<String> roadList = new ArrayList<>();
        ArrayList<Integer> solution = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();

        int count = 0;
        while(count < testNum){
            bulbNumList.add(sc.nextInt());
            roadList.add(sc.next());
            count++;
        }

        for(int i = 0;i<roadList.size();i++){
            solution.add(helper(roadList.get(i)));
        }
        for(int i = 0;i<solution.size();i++){
            System.out.println(solution.get(i));
        }
    }

    private static int addBulb(String str,int start){
        int count = 0;
        if(start + 4 < str.length()){
            String subStr = str.substring(start,start+3);
            switch(subStr){
                case "...":count++;break;
                case ".X.":count++;break;
                case ".XX":count++;break;
                case "..X":count++;break;
            }
        }else{
            String subStr = str.substring(start,str.length());
            for (int k = 0;k<subStr.length();k++){
                if (subStr.charAt(k) == '.'){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int helper(String str){
        int pointer = 0;
        int count = 0;
        while(pointer < str.length()){
            if(str.charAt(pointer) == 'X'){
                pointer++;
            }else {
                count += addBulb(str,pointer);
                pointer+=3;
            }
        }
        return count;
    }
}
/*
* 用例:
9
4  ..XX         1       1
1   X           0       0
8   ...X.X..    3       3
2   X.          1       1
7   X..X.X.     2       1
9   ....X.X..   3       2
7   ..X....     3       2
1   X           0       0
9   XX.....X.   3       3
对应输出应该为:




1
2
3
3
0
3

你的输出为:










* */
package Dji;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] first;
        String[] temp;
        int[] tempInt = null;
        int N;
        int money;
        ArrayList<int[]> list = new ArrayList<>();
        while (sc.hasNextLine()){
            first = sc.nextLine().split(" ");
            N = Integer.parseInt(first[0]);
            money = Integer.parseInt(first[1]);
            for (int i = 0;i<N;i++){
                temp = sc.nextLine().split(" ");
                tempInt = new int[temp.length];
                for (int j = 0;j<temp.length;j++){
                    tempInt[j] = Integer.parseInt(temp[j]);
                }
            }
            list.add(tempInt);
            getMaxSatisfy(list,money);
            list.clear();
        }
    }

    private static void getMaxSatisfy(ArrayList<int[]> list,int money){
        int satisfy = 0;

    }
}

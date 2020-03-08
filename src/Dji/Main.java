package Dji;

import java.io.*;
import java.util.*;

/*
* ��һ�������������� N, A, X, �ֱ��ʾ��bug����������һ��������һСʱ��debugЧ�ʵı�����
* �����ԺȵĿ�����Ŀ����1 <= N <= 100, 1 <= A <= 8, 1 <= X <= 8��

�ڶ�����N�����������ɿո�ָ����i��������ti��ʾ�����i��bug��Ҫ�ķ���������1 <= ti <= 1000��
* */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N_bug = sc.nextInt();
        int debugUp = sc.nextInt();
        int Max_Cof = sc.nextInt();
        String t = sc.nextLine();
        String temp = sc.nextLine();
        String[] bugs = temp.split(" ");
        int[] bgsTime = new int[bugs.length];
        for (int i = 0;i<bugs.length;i++){
            bgsTime[i] = Integer.parseInt(bugs[i]);
        }

        int[] bgsTimeAfterCofe = new int[bugs.length];
        for (int i = 0;i<bugs.length;i++){
            bgsTimeAfterCofe[i] = bgsTime[i] / debugUp;//�ȿ���֮��ÿ��bug��Ҫ��ʱ��
        }

        int totalTime = 480;//�ܹ���ʱ�䣬������ɵĻ������0
        int time = calTime(bgsTime,bgsTimeAfterCofe,Max_Cof,debugUp);
        if (time <= totalTime){
            System.out.println(time);
        }else {
            System.out.println(0);
        }

        int[] test = new int[]{5,6,1,2,8,6};
        sort(test);
        for (int e:test){
            System.out.println(e);
        }
    }

    private static int calTime(int[] bgsTime,int[] bgsTimeAfterCofe,int coffees,int debugUp){
        int time = 0;
        int time2 = 60;
        int index = bgsTime.length-1;
        int cur;
        while (coffees>0){
            sort(bgsTime);
            if (bgsTime[index] >= 60*debugUp){
                bgsTime[index] -= 60*debugUp;

            }else {
                int t = 60*debugUp-bgsTime[index];
                bgsTime[index] = 0;
                sort(bgsTime);
                bgsTime[index] -= t;
            }
            time += time2;
            coffees--;
        }
        for (int i = 0;i<bgsTime.length;i++){
            time += bgsTime[i];
        }
        return time;
    }
    //��С��������
    private static void sort(int[] arr){
        int temp = 0;
        for (int i = 0;i<arr.length-1;i++){
            for (int j = 0;j<arr.length-1;j++){
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

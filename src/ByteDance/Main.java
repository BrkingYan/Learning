package ByteDance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 0;
        String s;
        try {
            s = sc.next();
            N = Integer.parseInt(s);
        }catch (NumberFormatException e){
            System.out.println(-1);
        }

        if (N < 1 || N > Math.pow(10,18)){
            return;
        }
        int action = 0;
        while (N > 1){
            if (canBeSqrt(N)){
                N = (int)Math.sqrt((double)N);
            }else {
                N--;
            }
            action++;
        }
        System.out.println(action);
    }

    private static boolean canBeSqrt(int n){
        for (int i = 0;i< n;i++){
            if (i * i == n){
                return true;
            }else if (i * i > n){
                return false;
            }
        }
        return false;
    }
}

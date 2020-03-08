package AIQIYI;


import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner cc = new Scanner(System.in);
        double red = cc.nextDouble();
        double blue = cc.nextDouble();
        double res = help(red,blue);
        System.out.println(String.format("%.5f",res));
    }

    private static double help(double n,double m){
        if (n <= 0 || m < 0){
            return 0;
        }else if (n>0 && m <= 0){
            return 1;
        }else if(n == 1 && m == 1){
            return 0.5;
        }else{
            return (n/(n+m)+ (m/(n+m))*((m-1)/(n+m-1))*(n/(n+m-2))*help(n-1,m-2)
                    + (m/(n+m))*((m-1)/(n+m-1))*((m-2)/(n+m-2))*help(n,m-3));
        }
    }
}



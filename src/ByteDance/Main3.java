package ByteDance;


import java.util.ArrayList;
import java.util.Scanner;
//1234567890
public class Main3 {
    private static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int T = sc.nextInt();
        int count = 0;
        while (count < T){
            list.add((sc.nextInt()));
            count++;
        }

        for (int i = 0;i<list.size();i++){
            System.out.println(getX(list.get(i)));
        }

    }

    // y^2 = n + x^2
    private static int getX(int n){
        int x,y;
        for (x = 1;x<Math.sqrt(Integer.MAX_VALUE);x++){
            for (y = x;y<Math.sqrt(Integer.MAX_VALUE);y++){
                if (Math.pow(y,2) == Math.pow(x,2) + n){
                    return x;
                }
            }
        }
        return -1;
    }
}


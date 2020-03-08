package A_Tencent;


/*
* C2(H3?2)2 50
  2
  C 12
  H 1
* */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0;i<t;i++){
            int n = sc.nextInt();
            int count = n;
            HashSet<Point> set = new HashSet<>();
            List<Point> list1 = new ArrayList<>();

            for (int j = 0;j<n;j++){
                long t1,t2;
                t1 = sc.nextInt();
                t2 = sc.nextInt();
                Point p = new Point(t1,t2);
                set.add(p);
                list1.add(p);
            }
        }
    }

    private static class Point {
        long x;
        long y;

        Point(long x,long y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point that = (Point)obj;
            if (this.x == that.x && this.y == that.y){
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return new Long(x).hashCode() + new Long(y).hashCode()*2;
        }
    }
}

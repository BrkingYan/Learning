package MI_OJ.NO1;

import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] array = line.split(" ");
            long sum = 0;
            for (int i = 0; i < array.length; i++) {
                long a = Long.parseLong(array[i]);
                sum = sum + a;
            }
            System.out.println(sum);
        }
    }
}

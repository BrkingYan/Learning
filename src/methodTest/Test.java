package methodTest;

import java.util.*;
import java.io.*;
public class Test{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String line;
        while((line = reader.readLine()) != null){
            n = Integer.parseInt(line);
            help(n);
        }
    }

    private static void help(int n){
        if(n == 0){
            return;
        }
        if(n == 1){
            System.out.println(0);
        }
        int res = 0;
        int count = 0;
        int tmp = 0;
        while(n >= 2){
            if(n == 2){
                count++;
                break;
            }
            if(n % 3 != 0){
                n--;
                res++;
            }else{
                tmp = n / 3;
                count = count + tmp;
                n = tmp + res;
                res = 0;
            }
        }
        System.out.println(count);
    }

    private abstract class YY{
        public void jj(){

        }
    }

    public void Test(){

    }
}

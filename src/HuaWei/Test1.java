package HuaWei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int strNum = sc.nextInt();
        if (strNum == 0){
            System.out.print("");
        }else {
            String[] strings = new String[strNum];

            for (int i = 0; i< strNum; i++){
                strings[i] = sc.next();
            }

            List<String> list = new ArrayList<>();
            for (int i = 0;i<strings.length;i++){
                StringBuilder sb = new StringBuilder();
                if (strings[i].length() < 8){
                    sb.append(strings[i]);
                    for (int j = sb.length();j<8;j++){
                        sb.append("0");
                    }
                    list.add(sb.toString());
                }else if (strings[i].length() > 8){
                    int count = strings[i].length()/8;
                    int seq = 0;
                    while (seq < count){
                        String sub = strings[i].substring(seq*8,seq*8+8);
                        list.add(sub);
                        seq++;
                    }
                    String res = strings[i].substring(seq*8);
                    StringBuilder sbbb = new StringBuilder();
                    sbbb.append(res);
                    for (int n = 0;n<8-res.length();n++){
                        sbbb.append("0");
                    }
                    list.add(sbbb.toString());
                }else {
                    list.add(strings[i]);
                }
            }
            Collections.sort(list);
            for (int i = 0;i<list.size();i++){
                System.out.print(list.get(i));
                System.out.print(" ");
            }
        }
    }
}

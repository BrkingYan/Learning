package Pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;
        s = in.nextLine();
        char[] charArray = s.toCharArray();

        List<Character> charList = new ArrayList<>();
        for (int i = 0;i < charArray.length;i++){
            charList.add(charArray[i]);
        }

        for (int i = 0;i < charArray.length;i++){
            if (charArray[i] == ' '){
                charList.remove(i);
            }
        }


        for (int i = 0;i < charList.size();i++){
            char current = charArray[i];
            for (int j = i+1;j < charList.size();j++){
                if (current == (char)(charArray[j] + 32) || current == (char)(charArray[j] - 32)){
                    charList.remove(j);
                    break;
                }
            }
        }
        String newString = "";
        for (int i = 0;i < charList.size();i++){
            newString += (char)charList.get(i);
        }

        newString = newString.toLowerCase();

        char[] newCharArray = newString.toCharArray();
        char minChar = newCharArray[0];
        for (int i = 1; i<newCharArray.length;i++){
            if (minChar > newCharArray[i]){
                minChar = newCharArray[i];
            }
        }
        System.out.println(minChar);
    }
}

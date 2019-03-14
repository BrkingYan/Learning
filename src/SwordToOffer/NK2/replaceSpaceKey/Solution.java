package SwordToOffer.NK2.replaceSpaceKey;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String replaceSpace(StringBuffer str) {
        if (str != null){
            String inputStr = str.toString();
            String outputStr = "";
            List<Character> charList = new ArrayList<Character>();
            char[] charArray = inputStr.toCharArray();
            for (int i = 0;i < charArray.length; i++){
                if (charArray[i] != ' '){
                    charList.add(charArray[i]);
                }else {
                    charList.add('%');
                    charList.add('2');
                    charList.add('0');
                }
            }
            for (int j = 0;j < charList.size();j++){
                outputStr = outputStr + charList.get(j);
            }
            return outputStr;
        }else
            return "";
    }
}

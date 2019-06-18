package SwordToOffer.NK49.StrToInt;

/*
* ��һ���ַ���ת����һ������(ʵ��Integer.valueOf(string)�Ĺ��ܣ�
* ����string����������Ҫ��ʱ����0)��Ҫ����ʹ���ַ���ת�������Ŀ⺯����
* ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0��
* */
class Solution {
    public int StrToInt(String str) {
        boolean isNegative = false;

        if (str.equals("") || str.equals("-") || str.equals("+"))
            return 0;
        char[] chars = str.toCharArray();//0434342
        int signNum = 0;
        switch (chars[0]){
            case '-':
                isNegative = true;
                signNum++;
                break;
            case '+':
                signNum++;
                break;
            case '0':
                return 0;
        }
        if (!(chars[signNum] > '0' && chars[signNum] <= '9')){
            return 0;
        }

        for (int i = signNum;i<chars.length;i++){
            if (!(chars[i] >= '0' && chars[i] <= '9')){
                return 0;
            }
        }

        int sum = 0;
        int carry = 0;
        int[] ints = new int[chars.length-signNum];
        for (int i = 0;i<chars.length-signNum;i++){
            ints[i] = chars[i+signNum] - '0';
            System.out.println(ints[i]);
        }

        if (isNegative){
            for (int i = ints.length-1;i>=0;i--){
                sum -= ints[i] * Math.pow(10,carry);
                carry++;
            }
        }else {
            for (int i = ints.length-1;i>=0;i--){
                sum += ints[i] * Math.pow(10,carry);
                carry++;
            }
        }

        /*if (isNegative){
            if (sum == 2147483647){
                sum = 0 - sum;
            }else{
                sum = 0 - sum;
            }
        }*/
        return sum;
    }
}

package SwordToOffer.NK48.Add;

/*
* дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
* */
class Solution {
    public int Add(int num1,int num2) {
        int temp = 1;


        int count = 0;
        while (true){
            if ((int) Math.pow(2,count) == temp){
                break;
            }
            count++;
        }
        return count;
    }
}

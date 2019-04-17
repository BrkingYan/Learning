package SwordToOffer.NK33.GetUglyNumber_Solution;


/*
*  ��ֻ����������2��3��5��������������Ugly Number����
*  ����6��8���ǳ�������14���ǣ���Ϊ������������7��
*  ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
* */
class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index == 1){
            return 1;
        }
        int count = 1;
        int currentNum = 2;
        while (count < index){
            int current = currentNum;
            while (current % 2 == 0){
                current = current / 2;
            }
            while (current % 5 == 0){
                current = current / 5;
            }
            while (current % 3 == 0){
                current = current / 3;
            }
            if (current == 1){
                count++;
            }
            if (count < index){
                currentNum++;
            }
        }

        return currentNum;
    }
}

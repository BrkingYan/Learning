package SwordToOffer.NK33.GetUglyNumber_Solution;

class Solution2 {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0){
            return 0;
        }
        int[] result = new int[index];
        result[0] = 1;
        int count = 0;
        int time2 = 0;
        int time3 = 0;
        int time5 = 0;
        int temp;
        while (count < index-1){
            temp = min(result[time2] * 2,min(result[time3] * 3,result[time5] * 5));
            if (temp == result[time2] * 2)  time2++;
            if (temp == result[time3] * 3)  time3++;
            if (temp == result[time5] * 5)  time5++;
            count++;
            result[count] = temp;
        }
        return result[index-1];
    }

    private int min(int a,int b){
        if (a <= b){
            return a;
        }
        return b;
    }
}

package SwordToOffer.NK37.GetNumberOfK;

//统计一个数字在排序数组中出现的次数。
class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for (int i = 0;i<array.length;i++){
            if (k == array[i]){
                count++;
            }
        }
        return count;
    }
}

package SwordToOffer.NK37.GetNumberOfK;

//ͳ��һ�����������������г��ֵĴ�����
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

package SwordToOffer.NK10.RectCover_______;

/*
* ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
* ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
* */
public class Solution2 {
    public int RectCover(int target) {
        if (target == 1 || target == 2){
            return target;
        }
        return RectCover(target-1) + RectCover(target-2);
    }
}

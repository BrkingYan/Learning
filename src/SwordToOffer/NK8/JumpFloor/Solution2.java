package SwordToOffer.NK8.JumpFloor;

/*
* һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
* �����������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
* */
public class Solution2 {
    public int JumpFloor(int target) {
        if (target <= 3){
            return target;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}

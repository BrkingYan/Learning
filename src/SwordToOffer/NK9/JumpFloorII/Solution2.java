package SwordToOffer.NK9.JumpFloorII;

public class Solution2 {
    public int JumpFloorII(int target) {
        if (target == 1 || target == 2){
            return target;
        }
        int result = 0;
        for (int i = 1;i<target;i++){
            result += JumpFloorII(target-i) + 1;
        }
        return result;
    }
}

package SwordToOffer.NK21.IsPopOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*  输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
*  假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
*  但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
*
*  hint: 先进的后吐，后进的先吐
* */
class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        List<Integer> pushList = new ArrayList<>();
        for (int i = 0;i < pushA.length;i++){
            pushList.add(pushA[i]);
        }

        for (int i = 0;i < popA.length;i++){
            //找出popA中的元素在PushList中的坐标
            int index = pushList.indexOf(popA[i]);
            List<Integer> pushCopyList = new ArrayList<>();
            //复制剩余元素
            for (int j = 0;j < popA.length;j++){
                if (j != index){
                    pushCopyList.add(pushList.get(j));
                }
            }

        }
        return true;
    }
}

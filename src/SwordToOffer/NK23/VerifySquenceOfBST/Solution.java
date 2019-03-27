package SwordToOffer.NK23.VerifySquenceOfBST;


/*
*输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
* 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
* */
class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        /*
        * 若长度为1，说明已经经过检测
        * 若长度不为1，规定不通过检测
        * */
        if (sequence.length==1){
            return true;
        }else if (sequence.length == 0){
            return false;
        }

        //尾节点
        int nodeVal = sequence[sequence.length-1];
        //找出分界处的下标
        int index = 0;
        for (int i = 0;i < sequence.length-1;i++){
            if (nodeVal < sequence[i]){
                index = i-1;
                break;
            }
            //如果没找到比末尾大的，说明都比末尾小
            index = sequence.length-2;
        }

        //检查前后序列是否符合，前序列都比尾节点小，后序列都比尾节点大，的要求
        for (int i = index+1;i<sequence.length-2;i++){
            if (sequence[i] < nodeVal){
                return false;
            }
        }

        //以index为界，将前后序列分别克隆到新数组里面
        int[] leftSequence = new int[index+1];
        int[] rightSequence = new int[sequence.length-index-2];
        for (int i = 0;i <= index;i++){
            leftSequence[i] = sequence[i];
        }
        for (int i = 0;i<sequence.length-index-2;i++){
            rightSequence[i] = sequence[i+index+1];
        }

        //只有当两边都为0时，才是真的不通过检测
        return VerifySquenceOfBST(leftSequence) || VerifySquenceOfBST(rightSequence);
    }
}

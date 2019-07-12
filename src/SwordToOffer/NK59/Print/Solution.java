package SwordToOffer.NK59.Print;

import java.util.*;

/*
* ��ʵ��һ����������֮���δ�ӡ��������
* ��
* ��һ�а��մ����ҵ�˳���ӡ��
* �ڶ��㰴�մ��������˳���ӡ��
* �����а��մ����ҵ�˳���ӡ���������Դ����ơ�
* */
public class Solution {
    LinkedList<TreeNode> stack1 = new LinkedList<>();
    LinkedList<TreeNode> stack2 = new LinkedList<>();

    Map<Integer,LinkedList<TreeNode>> map = new HashMap<>();

    LinkedList<TreeNode> fullStack;
    LinkedList<TreeNode> emptyStack;

    ArrayList<Integer> aResult;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        if (pRoot == null){
            return new ArrayList<>();
        }

        int isNegtive = 0;
        map.put(0,stack1);
        map.put(1,stack2);

        stack1.push(pRoot);
        fullStack = stack1;
        emptyStack = stack2;

        isNegtive = 1;

        TreeNode temp;
        LinkedList<TreeNode> tempStack;

        while (!(fullStack.isEmpty() && emptyStack.isEmpty())){
           aResult = new ArrayList<>();
           fullStack = map.get((isNegtive +1)%2);
           emptyStack = map.get(isNegtive);
           while (!fullStack.isEmpty()){
               temp = fullStack.pop();
               aResult.add(temp.val);
               if (isNegtive == 1){
                   if (temp.left != null)
                       emptyStack.push(temp.left);
                   if (temp.right != null)
                       emptyStack.push(temp.right);
               }else {
                   if (temp.right != null)
                       emptyStack.push(temp.right);
                   if (temp.left != null)
                       emptyStack.push(temp.left);
               }
           }
           list.add(new ArrayList<>(aResult));
           isNegtive = (isNegtive +1) % 2;
       }
       return list;
    }

}

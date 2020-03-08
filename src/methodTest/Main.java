package methodTest;


import java.util.*;
class Main {

    public static void main(String[] args) {
        Main m = new Main();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        System.out.println(m.maxLevelSum(root));
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(root);
        TreeNode temp;
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp == null){
                if (queue.isEmpty()){
                    break;
                }
                //¼ÆËã²ãºÍ
                calSum(queue,list);
                queue.add(null);
            }else{
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for(int i = list.size()-1;i>=0;i--){
            if(list.get(i) >= max){
                max = list.get(i);
                idx = i;
            }
        }

        return idx;
    }

    public void calSum(LinkedList<TreeNode> queue,ArrayList<Integer> list){
        int sum = 0;
        Iterator<TreeNode> it = queue.iterator();
        while(it.hasNext()){
            sum += it.next().val;
        }
        list.add(sum);
    }
}

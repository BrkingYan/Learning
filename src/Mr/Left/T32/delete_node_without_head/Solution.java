package Mr.Left.T32.delete_node_without_head;


import Mr.Left.T20.delete_last_Kth_node_in_linkedList.Node;

/*
*  ���������е�һ���ڵ㣬�����������ͷ�ڵ㣬
*  ���ɾ���ýڵ�
* */
public class Solution {

    private static void delete(Node node){
        if (node == null){
            return;
        }
        Node after = node.next;
        if (after == null){
            throw new RuntimeException("can not delete last node");
        }
        node.val = after.val;
        node.next = after.next;
    }
}

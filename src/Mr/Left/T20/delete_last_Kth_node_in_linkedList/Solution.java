package Mr.Left.T20.delete_last_Kth_node_in_linkedList;


public class Solution {
    /*
    * 要求：
    *       时间复杂度：O(N)
    *       空间复杂度：O(1)
    * */
    public Node delete_Kth_in_single(Node head,int k){
        Node current = head;
        while (current!=null){
            k--;
            current = current.next;
        }
        if (k > 0){
            return null;
        }else if (k < 0){
            Node cur = head;
            while (cur != null){
                if (k == 0){
                    break;
                }
                k++;
                cur = cur.next;
            }
            cur.next = cur.next.next;
            return head;
        }else {
            Node newHead = head.next;
            return newHead;
        }
    }

}

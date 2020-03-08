package Mr.Left.T31.select_sort_of_list;

/*
*  单链表的选择排序
*  要求额外空间复杂度为O(1)
* */
public class Solution {
    private static class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,6,1};
        selectSort(arr);
        for(int e:arr) {
            System.out.println(e);
        }

        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(1);
        selectSort(head);

    }


    /*
    * 分头行动
    * 3->2->5->6->1
    * 3->2->5->6        1
    * 3->5->6           1->2
    * 5->6              1->2->3
    * 6                 1->2->3->5
    *                   1->2->3->5->6
    * */
    private static Node selectSort(Node head){
        Node cur = head;
        Node min;
        Node minPre;
        Node tail = null;//记录已排序部分的尾部
        while (cur != null){
            min = cur;
            minPre = getPreOfSmallest(cur);
            if (minPre != null){
                min = minPre.next;
                minPre.next = min.next;
            }
            cur = cur == min ? cur.next : cur;
            if (tail == null){
                head = min;
            }else {
                tail.next = min;
            }
            tail = min;
        }
        return head;
    }

    //返回剩余节点中最小节点的前一个节点
    private static Node getPreOfSmallest(Node head){
        Node pre = null;
        Node cur = head;
        Node min = cur;
        while (cur.next != null){
            if (cur.next.val < min.val){
                min = cur.next;
                pre = cur;
            }
            cur = cur.next;
        }
        return pre;
    }

    private static void selectSort(int[] arr) {
        int minIndex;
        int len = arr.length;
        int temp;
        for (int i = 0;i<len;i++){
            minIndex = i;
            for (int j = i+1;j<len;j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}

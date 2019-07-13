package LeetCode.LeetCode2.NK4;

import java.util.ArrayList;

public class Solution2 {
    public ListNode sortList(ListNode head) {
        if (head == null){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null){
            list.add(current.val);
            current = current.next;
        }
        System.out.println(list);
        int[] arr = new int[list.size()];
        for (int i = 0;i<list.size();i++){
            arr[i] = list.get(i);
        }

        quickSort(arr,0,arr.length-1);

        ListNode newHead = new ListNode(arr[0]);
        ListNode current2 = newHead;
        for (int i = 1;i<arr.length;i++){
            current2.next = new ListNode(arr[i]);
            current2 = current2.next;
        }

        return newHead;
    }


    private static void quickSort(int[] arr,int start,int end){
        if (start >= end){
            return;
        }
        int mid = partition(arr,start,end);
        quickSort(arr,start,mid-1);
        quickSort(arr,mid+1,end);
    }

    private static int partition(int[] arr,int start,int end){
        int leftPointer = start + 1;
        int rightPointer = end;
        int key = arr[start];

        int temp;

        while (true){
            //如果比key小，就继续往前走
            while (arr[leftPointer] < key){
                if (leftPointer == end){
                    break;
                }
                leftPointer++;
            }

            while (arr[rightPointer] > key){
                if (rightPointer == start){
                    break;
                }
                rightPointer--;
            }
            /*
            * 执行到这一步说明已经切分完全，直接退出循环
            * */
            if (leftPointer >= rightPointer){
                break;
            }
            /*
            * 执行到这一步说明还没切分完全，将左右指针的值互换后继续执行
            * */
            temp = arr[rightPointer];
            arr[rightPointer] = arr[leftPointer];
            arr[leftPointer] = temp;
        }
        temp = arr[start];
        arr[start] = arr[rightPointer];
        arr[rightPointer] = temp;
        return rightPointer;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(19);
        head.next.next = new ListNode(14);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(-3);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next.next.next = new ListNode(15);
        System.out.println(new Solution2().sortList(head));

    }
}

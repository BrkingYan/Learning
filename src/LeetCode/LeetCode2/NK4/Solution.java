package LeetCode.LeetCode2.NK4;

import java.util.ArrayList;

/*
*  ʹ�ó����ռ临�Ӷ���O��n log n��ʱ���ڶ������������
* */
public class Solution {
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
        int[] temp = new int[list.size()];
        sort(arr,temp,0,arr.length-1);

        ListNode newHead = new ListNode(arr[0]);
        ListNode current2 = newHead;
        for (int i = 1;i<arr.length;i++){
            current2.next = new ListNode(arr[i]);
            current2 = current2.next;
        }

        int[] arrr = new int[]{4,19,14,5,-3,1,8,5,11,15};
        sort(arrr,temp,0,arrr.length-1);
        for (int e : arrr){
            System.out.println(e);
        }
        return newHead;
    }

    private void merge(int[] arr,int[] temp,int start,int mid,int end){
        int leftPointer = start;
        int rightPointer = mid+1;

        for (int i = start;i<=end;i++){
            temp[i] = arr[i];
        }

        //ȷ��arr[start] �� arr[end]������Ԫ��
        for (int k = start;k<=end;k++){
            if (leftPointer > mid){
                arr[k] = temp[rightPointer++];
            }else if (rightPointer > end){
                arr[k] = temp[leftPointer++];
            }else if (temp[rightPointer] < temp[leftPointer]){//�ұߴ�
                arr[k] = temp[rightPointer++];
            }else {//��ߴ�����������
                arr[k] = temp[leftPointer++];
            }
        }
    }

    /*
    * ������arr�� start��end��Ԫ������
    * */
    private void sort(int[] arr,int[] temp,int start,int end){
        if (end <= start){
            return;
        }
        int mid = (start + end) / 2;
        sort(arr,temp,start,mid);
        sort(arr,temp,mid+1,end);
        merge(arr,temp,start,mid,end);
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
        System.out.println(new Solution().sortList(head));
    }
}

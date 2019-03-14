package LeetCode._1.AddTwoNumbers;

import java.util.List;

class Solution {
    /*int carry = 0;
    public ListNode addTwoNumbersForEqualLength(ListNode l1, ListNode l2) {
        ListNode l3Current;
        if (l1 == null && l2 == null){
            l3Current = null;
        }else if (l1 == null && l2 != null){
            l3Current = new ListNode(l2.val);
        }else if (l1 != null && l2 == null){
            l3Current = new ListNode(l1.val);
        }else {
            if ((l1.val + l2.val) >= 10){
                l3Current = new ListNode(l1.val + l2.val - 10 + carry);
                carry = 1;
            }else {
                l3Current = new ListNode(l1.val + l2.val + carry);
                carry = 0;
            }
        }
        if (l3Current != null){

            l3Current.next = addTwoNumbersForEqualLength(l1.next,l2.next);
        }
        return l3Current;
    }*/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode l3Current;
        int carry = 0;
        if (l1.val + l2.val + carry >= 10){
            l3.val = l1.val + l2.val + carry - 10;
            carry = 1;
        }else {
            l3.val = l1.val + l2.val + carry;
        }

        while (l1.next == null && l2.next == null){
            if (carry == 0){
                l3Current = null;
                break;
            }else {
                l3Current = new ListNode(carry);
            }
            carry = 0;
            l3.next = l3Current;
        }

        while (l1.next != null && l2.next == null){
            if (l1.val + carry == 10){
                l3Current = new ListNode(0);
                carry = 1;
            }else {
                l3Current = new ListNode(l1.val + carry);
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            l3.next = l3Current;
        }

        while (l1.next == null && l2.next != null){
            if (l2.val + carry == 10){
                l3Current = new ListNode(0);
                carry = 1;
            }else {
                l3Current = new ListNode(l2.val + carry);
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            l3.next = l3Current;
        }

        while (l1.next != null && l2.next != null){
            if (l1.val + l2.val + carry >= 10){
                l3Current = new ListNode(l1.val + l2.val + carry - 10);
                carry = 1;
            }else {
                l3Current = new ListNode(l1.val + l2.val + carry);
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            l3.next = l3Current;
        }

        return l3;
    }
}

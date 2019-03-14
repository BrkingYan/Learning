package SwordToOffer.NK16.Merge;

/*
*输入两个单调递增的链表，输出两个链表合成后的链表，
* 当然我们需要合成后的链表满足单调不减规则。
* */


import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        List arrayList1 = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        ListNode list3;
        ListNode list3Temp;

        if (list1 == null && list2 == null){
            return null;
        }
            while (list1 != null){
                arrayList1.add(list1.val);
                if (list1.next != null){
                    list1 = list1.next;
                }else {
                    break;
                }
            }


            while (list2 != null){
                arrayList2.add(list2.val);
                if (list2.next != null){
                    list2 = list2.next;
                }else {
                    break;
                }
            }



            arrayList1.addAll(arrayList2);
            for (int i = 0;i < arrayList1.size();i++){
                for (int j = i+1;j < arrayList1.size();j++){
                    if ((int)arrayList1.get(i) >= (int)arrayList1.get(j)){
                        int temp = (int)arrayList1.get(i);
                        arrayList1.set(i,arrayList1.get(j));
                        arrayList1.set(j,temp);
                    }
                }
            }
            list3 = new ListNode((int)arrayList1.get(0));
            list3Temp = list3;
            for (int i = 1;i < arrayList1.size();i++){
                list3Temp.next = new ListNode((int)arrayList1.get(i));
                list3Temp = list3Temp.next;
            }
            return list3;
        }
    }


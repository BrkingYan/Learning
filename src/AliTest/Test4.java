package AliTest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test4 {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String getIndexAndLongest(String users) {
        return null;
    }

    private static int getMostHappyBoy(String users){
        HashMap<Integer,Integer> map = new HashMap<>();
        Node head = init(users);
        Node cur = head;
        int maxCnt = 0;
        while (cur.index < users.length()){
            if (cur.val == 'g'){
                cur = cur.next;
                continue;
            }
            Node left = cur.pre;
            Node right = cur.next;
            int count = 0;
            while (left.val != 'b' || right.val != 'b'){
                if (left.val == 'g') {
                    count++;
                    left = left.pre;
                }
                if (right.val == 'g'){
                    count++;
                    right = right.next;
                }

            }
            map.put(cur.index,count);
            maxCnt = Math.max(maxCnt,count);
            cur = cur.next;
        }
        for (Integer i : map.keySet()){
            if (map.get(i) == maxCnt){
                return i;
            }
        }
        return -1;
    }

    private static Node init(String users){
        Node head = new Node(users.charAt(0),0);
        Node cur = head;
        for (int i = 1;i<users.length();i++){
            cur.next = new Node(users.charAt(i),i);
            cur.next.pre = cur;
            cur = cur.next;
        }
        cur.next = head;
        head.pre = cur;
        return head;
    }

    private static class Node{
        Node pre;
        Node next;
        char val;
        int index;
        Node(char val,int index){
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        System.out.println(getMostHappyBoy("bgbbbg"));
    }

    /*public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }

        res = getIndexAndLongest(_users);
        System.out.println(res);
    }*/
}

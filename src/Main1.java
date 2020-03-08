import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    private static class Node{
        String str;
        Node next;
        boolean preLinked = false;
        boolean postLinked = false;
        Node(String str){
            this.str = str;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] strs = input.split(" ");


        Node head = new Node(strs[0]);
        Node current = head;
        Node temp = current;
        int count = 1;
        while (count < strs.length){
            for (int i = 0;i<strs.length;i++){
                if (!current.str.equals(strs[i])){
                    if (getLastChar(current.str) == getFirstChar(strs[i])){
                        current.next = new Node(strs[i]);
                        current.postLinked = true;
                        current = current.next;
                        current.preLinked = true;
                    }
                }
            }
            if (current == temp){
                System.out.println(false);
                return;
            }
            count++;
        }
        System.out.println(true);
    }

    private static char getFirstChar(String s){
        return s.charAt(0);
    }

    private static char getLastChar(String s){
        return s.charAt(s.length()-1);
    }
}

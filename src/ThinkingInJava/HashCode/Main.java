package ThinkingInJava.HashCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.SortedSet;

public class Main {
    public static void main(String[] args) {
        Person o = new Person();
        System.out.println("hashCode() : "+o.hashCode());
        System.out.println("binary hashCode() : " + Integer.toHexString(o.hashCode()));
        System.out.println(o);

        Person p = new Person();
        System.out.println("hashCode() : "+p.hashCode());
        System.out.println("binary hashCode() : " + Integer.toHexString(p.hashCode()));
        System.out.println(p);

        System.out.println(o == p);

    }
}

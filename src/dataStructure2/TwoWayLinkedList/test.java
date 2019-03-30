package dataStructure2.TwoWayLinkedList;

import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        Student s1 = new Student(2,"sgs",21);
        Student s2 = new Student(1,"sgs",21);
        Student s3 = new Student(3,"sns",21);
        Student s4 = new Student(5,"s s",21);
        Student s5 = new Student(4,"sns",21);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.remove(3);
        System.out.println(list);
        System.out.println(list.get(3));
    }
}

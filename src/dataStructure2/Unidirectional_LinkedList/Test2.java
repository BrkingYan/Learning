package dataStructure2.Unidirectional_LinkedList;

import java.util.Iterator;

public class Test2 {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        list.add(new Student(1,"ss",21));
        list.add(new Student(2,"ss",21));
        list.add(new Student(3,"ss",21));
        Student s = new Student(4,"ww",24);
        list.add(s);
        list.add(new Student(5,"ss",21));
        list.add(new Student(6,"ss",21));
        list.remove(3);

        //System.out.println(list.size());
        //System.out.println(list.get(3));
        //list.remove(0);
        /*System.out.println(list);
        list.remove(s);
        System.out.println(list);
        System.out.println(list.isEmpty());*/
        StudentList list2 = new StudentList();
        list2.add(new Student(1,"ss",21));
        list2.add(new Student(2,"ss",21));
        list2.add(new Student(3,"ss",21));
        Student ss = new Student(4,"ww",24);
        list2.add(ss);
        list2.add(new Student(5,"ss",21));
        list2.add(new Student(6,"ss",21));

        list.reverse();
        System.out.println(list);
        /*list = list.addAll(list2);
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }*/
    }
}

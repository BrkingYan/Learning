package ThinkingInJava.ComparableInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args){
        Person p1 = new Person("z3",20,3900);
        Person p2 = new Person("l4",21,3300);
        Person p3 = new Person("w5",19,4900);
        Person p4 = new Person("z6",19,3100);
        Person p5 = new Person("zz",23,3000);

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);

        for (Person p : list){
            System.out.println(p);
        }

        /*
        * Collections则是集合类的一个工具类/帮助类，
        * 其中提供了一系列静态方法，用于对集合中元素进行排序、搜索以及线程安全等各种操作。
        * 常用方法有 Collections.binarySearch(List) Collections.sort(List) Collections.reverse(list)
        * 其中sort方法就是根据comparator来进行排序的
        * */
        Collections.sort(list);
        System.out.println("######################");
        for (Person p : list){
            System.out.println(p);
        }

        System.out.println("######################");

        Student s1 = new Student("z3",21,3000);
        Student s2 = new Student("l4",18,4000);
        Student s3 = new Student("w5",18,5000);
        Student s4 = new Student("z6",22,3000);
        Student s5 = new Student("kk",23,9000);

        List<Student> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);
        list1.add(s3);
        list1.add(s4);
        list1.add(s5);

        for (Student s : list1){
            System.out.println(s);
        }

        System.out.println("######################");

        StudentComparator comparator = new StudentComparator();
        Collections.sort(list1,comparator);

        for (Student s : list1){
            System.out.println(s);
        }
    }
}

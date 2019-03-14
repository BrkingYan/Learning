package dataStructure.BinarySearchTree;

import java.util.Comparator;
import java.util.Iterator;

public class PersonComparator implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge() > o2.getAge()){
            return 1;
        }else if (o1.getAge() < o2.getAge()){
            return -1;
        }else if (o1.getSalary() > o2.getSalary()){
            return 1;
        }else if (o1.getSalary() < o2.getSalary()){
            return -1;
        }
        return 0;
    }
}

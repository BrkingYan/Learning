package myTestBed;

import java.util.*;

public class EqualsTest {
    public static void main(String [] args){

        //Objects' method Test
        Employee alice = new Employee("Alice",5000,1996,1,1);
        System.out.println(alice.toString());
        System.out.println(alice.hashCode());

        Employee bob = new Manager("Bob",4000,1995,1,1);
        System.out.println(bob.toString());
        System.out.println(bob.hashCode());
        ((Manager) bob).setBonus(1000);
        System.out.println(bob.toString());

        Employee mike = new Employee("Mike",5000,1996,1,1);
        Employee mike1 = new Employee("Mike",5000,1996,1,1);

        System.out.println(mike.equals(mike1));

        System.out.println();


        //Map Test
        Map<Employee,Integer> hashMap = new HashMap<Employee,Integer>();
        hashMap.put(mike,1);
        hashMap.put(mike1,2);
        hashMap.put(alice,3);
        System.out.println(mike.hashCode() == mike1.hashCode());
        System.out.println(hashMap.get(mike));
        System.out.println(hashMap.get(mike1));
        System.out.println(hashMap.get(alice));

        System.out.println();

        //Set Test
        Set<Employee> hashSet = new HashSet<Employee>();
        hashSet.add(mike);
        hashSet.add(mike1);
        hashSet.add(alice);

        for(Employee e:hashSet)
            System.out.println(e.getName());

        System.out.println();


        //List Test
        List<Employee> arrayList = new ArrayList<Employee>();
        arrayList.add(mike);
        arrayList.add(mike1);
        arrayList.add(alice);

        for(Employee e:arrayList)
            System.out.println(e.getName());


        float a = 0.5f;
        if (a == 0){
            System.out.println("true");
        }
    }
}

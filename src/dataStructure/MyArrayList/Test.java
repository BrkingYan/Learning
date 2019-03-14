package dataStructure.MyArrayList;

import java.util.Iterator;

class Test {
    public static void main(String[] args){
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(0,1);
        list.add(1,2);
        list.add(2,3);
        list.add(3,4);
        System.out.println(list.toString());
        list.remove(0);
        System.out.println(list.toString());
        list.set(0,1);
        System.out.println(list.toString());

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }

        System.out.println(list.get(2));
        list.add(4,1);
        list.trimToSize();
        System.out.println(list);
    }
}

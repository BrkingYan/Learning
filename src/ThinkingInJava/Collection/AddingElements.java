package ThinkingInJava.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class AddingElements {
    public static void main(String[] args){
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        for (Integer i : collection){
            System.out.println(i.toString());
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        Integer[] moreInts = {6,7,8,9,10};
        collection.addAll(Arrays.asList(moreInts));
        for (Integer i : collection){
            System.out.println(i.toString());
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        Collection<Integer> moreInts1 = new ArrayList<Integer>(Arrays.asList(11,12,13,14,15));
        collection.addAll(moreInts1);
        for (Integer i : collection){
            System.out.println(i.toString());
        }
    }
}

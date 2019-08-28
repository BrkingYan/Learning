package ForTest;



import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(2,-2);
        map.put(1,-1);
        map.put(3,-3);
        for (int e : map.keySet()){
            //System.out.println(e);
        }

        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        set.add(1);
        set.add(3);
        for (int e : set){
            System.out.println(e);
        }


    }
}

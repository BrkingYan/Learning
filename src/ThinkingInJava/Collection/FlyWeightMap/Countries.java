package ThinkingInJava.Collection.FlyWeightMap;

import Design_Patterns2.consistency.CompositePattern.compositeItems.Entry;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;

public class Countries {

    // Map、getMap and getPartialMap
    private static Map<String,String> map = new FlyWeightMap();
    static Map<String,String> getMap(){
        return map;
    }
    static Map<String,String> getPartialMap(int size){
        return new FlyWeightMap(){
            @Override
            public Set<Map.Entry<String,String>> entrySet() {
                return new FlyWeightMap.EntrySet(size);
            }
        };
    }

    private static List<Map.Entry> entries = new ArrayList<>(map.entrySet());
    private static List<Map.Entry> getEntries(){
        return entries;
    }


    private static List<String> keys = new ArrayList<>(map.keySet());
    private static List<String> getKeys(){
        return keys;
    }
    private static List<String> getPartialKeys(int size){
        return new ArrayList<>(getPartialMap(size).keySet());
    }

    private static List<String> values = new ArrayList<>(map.values());
    private static List<String> getValues(){
        return values;
    }
    private static List<String> getPartialValues(int size){
        return new ArrayList<>(getPartialMap(size).values());
    }

    public static void main(String[] args) {
        System.out.println("map : " + getMap());
        System.out.println("partial map : " + getPartialMap(3));
        System.out.println("map's keys : " + getKeys());
        System.out.println("map's partial keys : " + getPartialKeys(3));
        System.out.println("map's values : " + getValues());
        System.out.println("map's partial values : " + getPartialValues(3));

        System.out.println("---------------------------");
        Set set = getPartialMap(3).keySet();
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(map.get("key2"));// FlyWeightMap的get方法继承自AbstractMap，它是基于迭代器实现的
        //Iterator<Entry<K,V>> i = entrySet().iterator();  entrySet()就是 entries
        //map.remove("key1"); 会报错，因为AbstractMap的remove方法是依赖EntrySet中迭代器的remove方法，
        //而这里迭代器的remove方法没实现

        System.out.println(map.entrySet());
        List<Map.Entry> list1 = new ArrayList<>(map.entrySet());
        System.out.println(list1);

        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"123");
        map.put(2,"234");
        List<Map.Entry> list = new ArrayList<>(map.entrySet());
        System.out.println(list);
    }
}

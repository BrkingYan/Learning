package ThinkingInJava.generics.Simple;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        Plate<? super Apple> plate = new Plate<>(new Fruit());
        //Fruit fruit = plate.getFood();
        Object obj = plate.getFood();
        System.out.println(obj.getClass().getSimpleName());
        plate.setFood(new Apple());
        System.out.println(plate.getFood().getClass().getSimpleName());
    }

    private static <T> void printListName(List<T> list){
        System.out.println(list.getClass().getSimpleName());
    }

    static <T> T getItem(Plate<T> foodPlate){
        return foodPlate.getFood();
    }

    static <T> void printItem(T item){
        System.out.println(item.getClass().getSimpleName());
    }

    static <K,V> V getMapKey(Map<K,V> map,K key){
        return map.get(key);
    }

    static <T> List<T> fillList(T... items){
        List<T> list = new ArrayList<>();
        for (T item : items){
            list.add(item);
        }
        return list;
    }
}

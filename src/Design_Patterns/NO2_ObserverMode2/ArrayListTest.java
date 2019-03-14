package Design_Patterns.NO2_ObserverMode2;

import java.util.ArrayList;

 class ArrayListTest {
    public void testArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(0);

        System.out.println(list);

        System.out.println(list.get(0));
    }
}

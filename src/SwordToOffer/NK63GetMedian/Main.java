package SwordToOffer.NK63GetMedian;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(5.0);
        list.add(2.0);
        list.add(3.0);
        list.add(6.0);
        list.add(1.0);
        Solution s = new Solution();
        s.sort(list);
        System.out.println(list);
    }
}

package myTestBed;


import java.util.ArrayList;
import java.util.List;

public class LocalArrayTest {
    List locationQueue = new ArrayList();

    public static void main(String[] args){
        LocalArrayTest localArrayTest = new LocalArrayTest();
        List list = localArrayTest.method();
        System.out.println(list.get(0));
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
        List list1 = (List) list.get(0);
        System.out.println(list1.get(1));

    }

    List method(){
        List axisArray = new ArrayList();
        axisArray.add(1);
        axisArray.add(2);
        locationQueue.add(axisArray);
        return locationQueue;
    }
}

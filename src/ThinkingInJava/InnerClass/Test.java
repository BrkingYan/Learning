package ThinkingInJava.InnerClass;

import edu.princeton.cs.algs4.LinkedStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        LinkedList<Object> linkedList = new LinkedList<>();
        List<Object> arrayList = new ArrayList<>();
        new Test().changeCollection(linkedList);

    }

    void changeCollection(List<Object> list){
        list.size();
    }
}

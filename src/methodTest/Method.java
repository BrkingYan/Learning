package methodTest;

import java.util.ArrayList;
import java.util.List;

public class Method {
    List<String> list = new ArrayList<>();

    public static void main (String[] args){
        Method method = new Method();
        method.list.add("1");
        method.list.add("2");

        method.changeList(method.list);
    }

    private void changeList(List<String> list){
        String s = list.get(1);
        System.out.println(s);
    }
}

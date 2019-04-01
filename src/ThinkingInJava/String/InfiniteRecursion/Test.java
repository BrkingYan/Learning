package ThinkingInJava.String.InfiniteRecursion;

import java.util.ArrayList;
import java.util.List;

/*
*  将字符串和一个地址连接会发生无意识的toString()方法的递归调用
* */
public class Test {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person());
        list.add(new Person());
        System.out.println(list);
    }
}

package ThinkingInJava.String.InfiniteRecursion;

import java.util.ArrayList;
import java.util.List;

/*
*  ���ַ�����һ����ַ���ӻᷢ������ʶ��toString()�����ĵݹ����
* */
public class Test {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person());
        list.add(new Person());
        System.out.println(list);
    }
}

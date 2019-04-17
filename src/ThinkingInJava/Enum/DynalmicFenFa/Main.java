package ThinkingInJava.Enum.DynalmicFenFa;


/*
*  java只支持动态单分发(根据运行时的实际类型单分发)，只考虑方法所属对象
* */
public class Main {
    public static void main(String[] args) {
        String s1 = "ab"; //s1是String类型
        Object o = s1 +"c";//o实际上是String类型
        String s = "abc";
        System.out.println(o.equals(s));//这里o的实际类型是String，因此调用的是String的equals()方法，因此比较的是内容
        System.out.println(o == s);//false
        System.out.println(o.getClass().getSimpleName());//String
    }

}

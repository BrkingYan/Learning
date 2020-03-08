package AliTest;

public class Test8 {
    public static void main(String[] args) {
        Test7 t = new Test7(2);
        t.put(1,1);
        t.put(2,2);
        System.out.println(t.get(1));
        t.put(3,3);
        System.out.println(t.get(2));
        t.put(4,4);
        System.out.println(t.get(1));
        System.out.println(t.get(3));
        System.out.println(t.get(4));

    }
}

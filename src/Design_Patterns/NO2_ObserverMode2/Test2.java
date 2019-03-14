package Design_Patterns.NO2_ObserverMode2;

public class Test2 {
    public static void main(String [] args){

        Person p1 = new Person("123",20);
        System.out.println(p1.getName()+"..."+p1.getAge());
        p1.addAge(3);
        System.out.println(p1.getName()+"..."+p1.getAge());
        p1.addName("a");
        System.out.println(p1.getName()+"..."+p1.getAge());
    }

}

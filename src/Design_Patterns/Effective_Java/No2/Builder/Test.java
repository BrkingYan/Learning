package Design_Patterns.Effective_Java.No2.Builder;

public class Test {
    public static void main(String[] args){
        Person p = new Person.Builder(1,"zhangsan").age(12).address("Wu Han").phone("12343343434").desc("good").sex("male").build();
        System.out.println(p);
        System.out.println("***************");
        Person p1 = new Person.Builder(2,"zhangsan").age(19).address("Wu Han").phone("12343343434").desc("bad").sex("female").build();
        System.out.println(p1);
    }
}

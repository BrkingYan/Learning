package ThinkingInJava.Genric;

public class Main {
    public static void main(String[] args) {
        Person p = new Student();
        System.out.println("get simple name : "+p.getClass().getSimpleName());
    }


}

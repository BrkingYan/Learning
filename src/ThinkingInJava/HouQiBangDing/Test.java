package ThinkingInJava.HouQiBangDing;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Student s1 = new Student();
        Person s2 = new Student();
        test.showPerson(s1);
        test.showPerson(s2);
    }

    void showPerson(Person p){
        p.show();
    }
}

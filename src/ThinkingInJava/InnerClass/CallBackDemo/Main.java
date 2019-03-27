package ThinkingInJava.InnerClass.CallBackDemo;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        Teacher teacher = new Teacher(student);

        teacher.askQuestion("1 + 1 = ?");
    }
}

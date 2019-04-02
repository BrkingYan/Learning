package ThinkingInJava.Genric;

public class Test {
    public static void main(String[] args) {
        Class<? extends Person> workerClass = Worker.class;
        Class<? extends Person> studentClass = Student.class;
        Class<? extends Person> personClass = Person.class;
        try {
            System.out.println("workerClass.newInstance()  : " + workerClass.newInstance().getClass().getSimpleName());
            System.out.println("----------------");
            System.out.println("workerClass.newInstance()  : " + studentClass.newInstance().getClass().getSimpleName());
            System.out.println("----------------");
            System.out.println("workerClass.newInstance()  : " + personClass.newInstance().getClass().getSimpleName());
            System.out.println("----------------");
            System.out.println("workerClass.getSuperClass()  : " + studentClass.getSuperclass().getSimpleName());
            System.out.println("----------------");
            Class midStudent = MidStudent.class;
            System.out.println(midStudent.getSuperclass().getSimpleName());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

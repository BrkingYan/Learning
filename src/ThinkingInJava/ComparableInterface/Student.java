package ThinkingInJava.ComparableInterface;

class Student {
    private String name;
    private int age;
    private int salary;

    public Student(String name,int age,int salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Student " + this.name + "  age : " + this.age + "  salary : " + this.salary;
    }
}

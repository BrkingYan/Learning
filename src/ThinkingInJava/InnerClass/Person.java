package ThinkingInJava.InnerClass;

abstract class Person {
    private String name;
    private int age;

    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    abstract int getId();
}

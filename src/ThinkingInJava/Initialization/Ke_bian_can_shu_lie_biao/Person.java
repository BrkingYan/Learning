package ThinkingInJava.Initialization.Ke_bian_can_shu_lie_biao;

class Person {
    private String name;
    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "name : " + this.name + " age : " + this.age;
    }
}

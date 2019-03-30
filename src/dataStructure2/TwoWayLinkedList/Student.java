package dataStructure2.TwoWayLinkedList;

class Student {
    private int id;
    private String name;
    private int age;

    Student next;
    Student prev;

    Student(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
        next = null;
        prev = null;
    }

    @Override
    public String toString() {
        return "id : " + id + " name : " + name + " age : " + age;
    }
}

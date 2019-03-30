package dataStructure2.RingLinkedList;

/*
 *  student 作为链表的节点
 * */
class Student {
    int id;
    private String name;
    private int age;

    Student next;

    Student(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
        next = null;
    }

    Student(){
        this(0,null,0);
    }

    @Override
    public String toString() {
        return "id : " + id + " name : " + name + " age : " + age;
    }
}

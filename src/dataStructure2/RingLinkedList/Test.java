package dataStructure2.RingLinkedList;

public class Test {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        Student s1 = new Student(1,"jack3",21);
        Student s2 = new Student(2,"jack3",22);
        Student s3 = new Student(3,"jack3",23);
        Student s4 = new Student(4,"jack3",24);
        Student s5 = new Student(5,"jack3",25);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        Student s11 = new Student(6,"jack3",21);
        Student s22 = new Student(7,"jack3",22);
        Student s33 = new Student(8,"jack3",23);
        Student s44 = new Student(9,"jack3",24);
        Student s55 = new Student(10,"jack3",25);

        StudentList li2 = new StudentList();
        li2.add(s11);
        li2.add(s22);
        li2.add(s33);
        li2.add(s44);
        li2.add(s55);
        list.addAll(li2);
        System.out.println(list);
        list.printEntireList(s11);
    }
}

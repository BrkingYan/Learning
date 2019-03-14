package dataStructure.BinarySearchTree;

public class Test {
    public static void main(String[] args){
        Person p1 = new Person("z3",21,2222);
        Person p2 = new Person("z3",22,1222);
        Person p3 = new Person("z3",15,3343);
        Person p4 = new Person("z3",19,1111);
        Person p5 = new Person("z3",23,3434);
        PersonComparator comparator = new PersonComparator();
        BinarySearchTree tree = new BinarySearchTree(null);

        tree.insert(p1);
        tree.insert(p2);
        tree.insert(p3);
        tree.insert(p4);
        tree.insert(p5);

        boolean flag = tree.contains(p3);
        System.out.println(flag);
    }
}

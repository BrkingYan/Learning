package dataStructure.BinarySearchTree;

class BinaryNode<Person>  {
    private BinaryNode left;
    private BinaryNode right;
    private Person person; //the data in the node

    public BinaryNode(Person p){
        this.person = p;
    }

    public BinaryNode(Person p,BinaryNode left,BinaryNode right){
        this.left = left;
        this.right = right;
    }


    /*@Override
    public int compareTo(BinaryNode o) {
        if (this.person > o.person){

        }
    }*/

    public Person getPerson() {
        return person;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public BinaryNode getRight() {
        return right;
    }
}

package dataStructure2.Unidirectional_LinkedList;

public class AddTwoNum {
    private Node node;
    public static void main(String[] args) {
        Node n1 = new Node(9);
        n1.next = new Node(8);
        //n1.next.next = new Node(3);
        Node n2 = new Node(1);
        //n2.next = new Node(6);
        //n2.next.next = new Node(4);

        Node n3 = new AddTwoNum().addTwoNum(n1,n2);
        System.out.println(n3.val);
        System.out.println(n3.next.val);
        System.out.println(n3.next.next.val);
    }

    Node addTwoNum(Node node1,Node node2){
        Node current = node;
        int carry = 0;
        while ((node1 == null && node2 == null && carry == 1) || (node1 != null || node2 != null)){
            int sum;
            if (node1 == null){
                if (carry == 0){
                    sum = node2.val + carry;
                    node2 = node2.next;
                }else {
                    if (node2 == null){
                        sum = carry;
                    }else {
                        sum = node2.val + carry;
                    }
                }
            }else if (node2 == null){
                if (carry == 0){
                    sum = node1.val + carry;
                    node1 = node1.next;
                }else {
                    sum = node1.val + carry;
                }
            }else {
                sum = node1.val + node2.val + carry;
                node1 = node1.next;
                node2 = node2.next;
            }
            if (current != null){
                if (sum <= 9){
                    current.next = new Node(sum);
                    carry = 0;
                }else {
                    current.next = new Node(sum-10);
                    carry = 1;
                }
                current = current.next;
            }else {
                if (sum <= 9){
                    current = new Node(sum);
                    carry = 0;
                }else {
                    current = new Node(sum-10);
                    carry = 1;
                }
                node = current;
            }
        }
        return node;
    }
}

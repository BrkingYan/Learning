package dataStructure2.Stack;

public class Test {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        stack.pop();
        stack.pop();
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
    }
}

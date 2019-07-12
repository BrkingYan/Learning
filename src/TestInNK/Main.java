package TestInNK;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        sb.append(4);

        sb.delete(1,2);
        System.out.println(sb.toString());
        System.out.println(sb.length());
    }
}

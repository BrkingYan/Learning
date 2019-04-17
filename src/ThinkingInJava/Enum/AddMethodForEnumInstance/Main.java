package ThinkingInJava.Enum.AddMethodForEnumInstance;

public class Main {
    public static void main(String[] args) {
        for (Color color : Color.class.getEnumConstants()){
            System.out.print(color.name() + " : ");
            color.show();
            color.solidShow();
        }
    }
}

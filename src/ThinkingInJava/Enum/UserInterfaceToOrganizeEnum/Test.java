package ThinkingInJava.Enum.UserInterfaceToOrganizeEnum;

public class Test {
    public static void main(String[] args) {
        Food food = Food.Beverage.COFFEE;
        System.out.println(((Food.Beverage) food).name());
    }
}

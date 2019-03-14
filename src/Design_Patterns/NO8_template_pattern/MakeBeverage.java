package Design_Patterns.NO8_template_pattern;

public class MakeBeverage {
    public static void main(String[] args){
        /*Tea tea = new Tea();
        tea.prepareRecipe();*/

        System.out.println("##########################");

        TeaWithHook teaWithHook = new TeaWithHook();
        CoffeeWithHook coffeeWithHook = new CoffeeWithHook();

        teaWithHook.prepareRecipe();
        coffeeWithHook.prepareRecipe();
    }
}

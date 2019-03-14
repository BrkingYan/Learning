package Design_Patterns.NO4_Factory_Norm;

public class FactoryNormTest {
    public static void main(String[] args){
        //normal factory
        System.out.println("**************the norm factory**************");
        PizzaStore ps = new PizzaStore_Chicago();
        ps.orderPizza("cheese");
        //ps.orderPizza("123");

        //normal factory with IngredientFactory
        System.out.println("************BJ store use the Ingredient factory************");
        PizzaStore ps1 = new PizzaStore_BJ();
        Pizza pizza = ps1.orderPizza("cheese");
        System.out.println(pizza.sauce.getType());
        System.out.println(pizza.clam.getType());
        System.out.println(pizza.cheese.getType());

        System.out.println("****************the clam test of BJ store ******************");
        Pizza pizza1 = ps1.orderPizza("clam");
        System.out.println(pizza.sauce.getType());
        System.out.println(pizza.clam.getType());
        System.out.println(pizza.cheese.getType());




       /* Pizza pizza1 = ps1.orderPizza("clam");
//        String s1 = pizza1.cheese.getType();
        String s2 = pizza1.sauce.getType();
        String s3 = pizza1.clam.getType();
        System.out.println(s2 +"..."+ s3);*/



    }
}

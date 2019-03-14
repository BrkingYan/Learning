package Design_Patterns.NO4_Factory_Simple;

public class FactorySimpleTest {
    public static void main(String[] args){
        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
        PizzaStore ps = new PizzaStore(simplePizzaFactory);
        Pizza pizza = ps.orderPizza("cheese");

        ps.orderPizza("clam");

    }
}

package Design_Patterns.NO4_Factory_Mode;


/*
*  the pizza is the observer , can be discounted only after it is created
* */
public class Customer {
    public static void main(String [] args){

        PizzaStore store2 = new PizzaStore_NY();
        PriceData priceData = new PriceData();
        Food pizza3 = store2.createPizza("clam",priceData);
        System.out.println(pizza3.state+"...$"+pizza3.cost());
        priceData.setDisCount(2);
        System.out.println(pizza3.state+"...$"+pizza3.cost());

        Food pizza4 = store2.createPizza("clam");
        System.out.println(pizza4.state+"...$"+pizza4.cost());
    }
}

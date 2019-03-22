package Design_Patterns2.GiveToSubClass.Factory_Method;

import Design_Patterns2.GiveToSubClass.Factory_Method.cake.Cake;
import Design_Patterns2.GiveToSubClass.Factory_Method.cake.CakeFactory;
import Design_Patterns2.GiveToSubClass.Factory_Method.framework.Factory;
import Design_Patterns2.GiveToSubClass.Factory_Method.framework.Product;
import Design_Patterns2.GiveToSubClass.Factory_Method.idcard.IdCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IdCardFactory();
        Product card1 = factory.create("james");
        Product card2 = factory.create("mike");
        Product card3 = factory.create("john");
        card1.use();
        card2.use();
        card3.use();

        System.out.println(((IdCardFactory) factory).getOwners());

        System.out.println("#########################");
        Factory factory1 = new CakeFactory();
        Product cake1 = factory1.create("james");
        Product cake2 = factory1.create("mike");
        Product cake3 = factory1.create("john");
        cake1.use();
        cake2.use();
        cake3.use();
        System.out.println(((CakeFactory)factory1).getProtagonists());
    }
}

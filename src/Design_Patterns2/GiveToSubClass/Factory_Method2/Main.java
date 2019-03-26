package Design_Patterns2.GiveToSubClass.Factory_Method2;

public class Main {
    public static void main(String[] args) {
        //IdCard.buildFactory();
        Factory factory = IdCard.getIdCardFactory();
        //给多个用户生产card
        Product card1 = factory.create("mike");
        Product card2 = factory.create("john");
        Product card3 = factory.create("bob");

        //使用产品
        card1.use();
        card2.use();
        card3.use();
        System.out.println(factory.getOwners());

        Factory factory1 = IdCard.getIdCardFactory();
        System.out.println(factory==factory1);

        //buildFactory重新建了一个工厂
        //IdCard.buildFactory();
        Factory factory2 = IdCard.getIdCardFactory();
        System.out.println(factory==factory2);
    }
}

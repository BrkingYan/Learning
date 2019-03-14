package Design_Patterns.NO3_Decorator_Mode;

public class StarBuzzCoffee {

    public static void main(String [] args){
        Beverage beverage = new DarkRoast_B2();
        System.out.println("当前饮料为："+beverage.getDescription()+"  价格为："+beverage.cost());
        beverage = new Mocha(beverage);
        System.out.println("当前饮料为："+beverage.getDescription()+"  价格为："+beverage.cost());
        beverage = new Whip(beverage);
        System.out.println("当前饮料为："+beverage.getDescription()+"  价格为："+beverage.cost());

    }
}
/*
*       Beverage b1 = new Decaf_B4();
        String className = b1.getClass().getName();
        System.out.println(className);

        b1 = new Milk(b1);
        className = b1.getClass().getName();
        System.out.println(className);

        b1 = new SmallSize(b1);
        className = b1.getClass().getName();
        System.out.println(className);

        System.out.println(b1.getDescription() + "  $" + b1.cost());
* */


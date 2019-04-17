package ThinkingInJava.generics.Border;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        MealPlate<Meal> p3 = new MealPlate<>(new SolidMeal());
        p3.showMeal();
        System.out.println("---------------------");

        FruitPlate<Fruit> p2 = new FruitPlate<Fruit>(new Fruit());
        p2.showFruit();
        System.out.println("--------------$-------");

        FruitPlate<Apple> pp = new FruitPlate<>(new Apple());
        pp.showFruit();

        FruitPlate<Fruit> pp1 = new FruitPlate<>(new Apple());
        pp1.showFruit();

        MixPlate<MixFood> p1 = new MixPlate<>(new MixFood());
        p1.showFruit();
        p1.showMeal();
        System.out.println("---------------------");

        MixPlate<? extends Meal> ppp = new MixPlate<>(new MixFood());
        ppp.showMeal();
        ppp.showFruit();



        FruitPlate<Fruit> p0 = new FruitPlate<>(new SolidFruit());
        p0.showFruit();


    }
}

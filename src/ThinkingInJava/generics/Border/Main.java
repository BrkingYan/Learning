package ThinkingInJava.generics.Border;

public class Main {
    public static void main(String[] args) {

        MealPlate<Meal> p3 = new MealPlate<>(new SolidMeal());
        p3.showMeal();
        System.out.println("---------------------");

        FruitPlate<Fruit> p2 = new FruitPlate<Fruit>(new Fruit());
        p2.showFruit();
        System.out.println("---------------------");

        MixPlate<MixFood> p1 = new MixPlate<>(new MixFood());
        p1.showFruit();
        p1.showMeal();
        System.out.println("---------------------");

        FruitPlate<Fruit> p0 = new FruitPlate<>(new SolidFruit());
        p0.showFruit();

    }
}

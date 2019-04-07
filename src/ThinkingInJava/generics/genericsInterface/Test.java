package ThinkingInJava.generics.genericsInterface;


/*
*  �����е�static�����ᱻ�������๲��
* */
public class Test {
    public static void main(String[] args) {
        CoffeeGenerator generator = new CoffeeGenerator(5);
        Coffee c1 = generator.next();
        System.out.println("c1's id " + c1.id);
        System.out.println(c1.getClass().getSimpleName());
        System.out.println("Coffee's counter : " + Coffee.counter);
        System.out.println("Mocha's counter : " + Mocha.counter);
        System.out.println("Latte's counter : " + Mocha.counter);

        Coffee c2 = generator.next();
        System.out.println("c2's id " + c2.id);
        System.out.println(c2.getClass().getSimpleName());
        System.out.println("Coffee's counter : " + Coffee.counter);
        System.out.println("Mocha's counter : " + Mocha.counter);
        System.out.println("Latte's counter : " + Mocha.counter);

        System.out.println("-------------------------------------");

        for (Coffee c : new CoffeeGenerator(1)){
            System.out.println(c);
        }
    }
}

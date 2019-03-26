package Design_Patterns2.consider_separately.BridgePattern;

public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImplementor("hello"));
        RandomDisplay d2 = new RandomDisplay(new StringDisplayImplementor("hello china"));
        MultiDisplay d3 = new MultiDisplay(new StringDisplayImplementor("hello"));
        //Display d4 = new Display(new FileDisplayImplementor("E:\\kkk.txt"));
        MultiDisplay d5 = new MultiDisplay(new FileDisplayImplementor("E:\\kkk.txt"));

        d1.display();
        d2.randomDisplay(5);
        d3.display();
        d3.multiDisplay(3);
        //d4.display();
        d5.multiDisplay(3);
    }
}

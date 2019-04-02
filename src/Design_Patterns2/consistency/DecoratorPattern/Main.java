package Design_Patterns2.consistency.DecoratorPattern;

public class Main {
    public static void main(String[] args) {
        /*StringDisplay display = new StringDisplay("hello world");
        display.show();
        SideBorderDisplay borderedDisplay = new SideBorderDisplay(display,'*');
        borderedDisplay.show();
        FullBorderDisplay fullBorderDisplay = new FullBorderDisplay(borderedDisplay,'/');
        fullBorderDisplay.show();
        FullBorderDisplay fullBorderDisplay1 = new FullBorderDisplay(fullBorderDisplay,'*');
        fullBorderDisplay1.show();*/

        MultiStringDisplay multiStringDisplay = new MultiStringDisplay("4567");
        multiStringDisplay.add("123");
        multiStringDisplay.add("123");
        multiStringDisplay.show();
        System.out.println("-----------------------------------------------------------");
        SideBorderDisplay sideBorderDisplay = new SideBorderDisplay(multiStringDisplay,'*');
        sideBorderDisplay.show();
        System.out.println("-----------------------------------------------------------");
        FullBorderDisplay fullBorderDisplay = new FullBorderDisplay(sideBorderDisplay,'*');
        fullBorderDisplay.show();
    }
}

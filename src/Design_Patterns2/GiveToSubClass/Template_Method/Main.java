package Design_Patterns2.GiveToSubClass.Template_Method;

public class Main {
    public static void main(String[] args) {
        AbstractDisplay display1 = new CharDisplay('h');
        AbstractDisplay display2 = new StringDisplay("hello");
        display1.display();
        display2.display();
    }
}

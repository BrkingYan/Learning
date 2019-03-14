package Interface;

public class InterfaceTest implements Months {
    public static void main(String[] args){
        new InterfaceTest().method();
        //System.out.println(a);
    }


    public void method(){
        int b = a ;
        b++;
        System.out.println("a = " + b);
    }
}

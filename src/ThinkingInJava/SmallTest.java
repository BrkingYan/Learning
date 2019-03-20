package ThinkingInJava;

public class SmallTest {

    public SmallTest(){
        i = 1;
    }

    int i = 0;

    public static void main(String[] args){
        SmallTest smallTest = new SmallTest();
        System.out.println(smallTest.i);
    }
}

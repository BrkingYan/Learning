package myTestBed;

public class VolatileTest {
    private volatile int a = 3;
    public static void main(String[] args) {
        VolatileTest t = new VolatileTest();
        t.cal();
    }

    private int cal(){
        int b = a + 10;
        int c = b * 2;
        return c;
    }
}

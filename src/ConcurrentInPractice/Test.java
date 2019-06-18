package ConcurrentInPractice;

public class Test {
    public static void main(String[] args) {
        Tester tester = new Tester();
        Thread t1 = new Thread(new Task());
        tester.init();
        Thread t2 = new Thread(new Task());
        t1.start();
        t2.start();

    }
}

package ThinkingInJava.Concurrent.sharedResource;

public class Test {
    public static void main(String[] args) {
        //EvenChecker.test(new EvenGenerator());
        EvenChecker.test(new MutexEvenGenerator());
    }
}

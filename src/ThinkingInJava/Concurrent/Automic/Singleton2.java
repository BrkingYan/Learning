package ThinkingInJava.Concurrent.Automic;

public class Singleton2 {
    private static class SingletonHolder {
        private static final Singleton2 singleton = new Singleton2();

    }

    private Singleton2() {}

    public static Singleton2 getInstance() {
        return SingletonHolder.singleton;
    }
}

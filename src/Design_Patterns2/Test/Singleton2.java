package Design_Patterns2.Test;

public class Singleton2 {
    private static Singleton2 instance;
    private Singleton2(){}

    public static Singleton2 getInstance(){
        synchronized (Singleton2.class){
            if (instance == null){
                instance = new Singleton2();
            }
            return instance;
        }
    }
}

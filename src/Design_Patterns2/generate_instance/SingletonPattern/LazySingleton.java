package Design_Patterns2.generate_instance.SingletonPattern;

public class LazySingleton {
    private static  LazySingleton instance = null;

    private LazySingleton(){
        System.out.println("������һ��LazySingleton");
    }

    public static LazySingleton getInstance(){
        if (instance == null) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            instance = new LazySingleton();
        return instance;
    }
}

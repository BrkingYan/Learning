package Design_Patterns2.generate_instance.SingletonPattern;

public class SychronLazySingleton3 {
    private static  SychronLazySingleton3 instance = null;

    private SychronLazySingleton3(){
        System.out.println("产生了一个LazySingleton");
    }

    public static SychronLazySingleton3 getInstance(){
        //双重锁
            if (instance == null) {
                try {
                    synchronized (SychronLazySingleton3.class) {
                        if (instance == null){
                            Thread.sleep(300);
                            instance = new SychronLazySingleton3();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        return instance;
    }
}

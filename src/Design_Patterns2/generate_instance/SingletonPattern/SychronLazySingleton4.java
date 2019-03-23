package Design_Patterns2.generate_instance.SingletonPattern;

class SychronLazySingleton4 {
    private static  SychronLazySingleton4 instance = null;

    private SychronLazySingleton4(){
        System.out.println("产生了一个LazySingleton");
    }

    public static SychronLazySingleton4 getInstance(){
        if (instance == null) {
            try {
                synchronized (SychronLazySingleton4.class){ //无法同步
                    Thread.sleep(300);
                    instance = new SychronLazySingleton4();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}

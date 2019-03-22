package Design_Patterns2.generate_instance.SingletonPattern;

class SychronLazySingleton {
    private static  SychronLazySingleton instance = null;

    private SychronLazySingleton(){
        System.out.println("产生了一个LazySingleton");
    }

    public static SychronLazySingleton getInstance(){
        synchronized (SychronLazySingleton.class){ //其实也是锁住一个方法
            if (instance == null) {
                try {
                        Thread.sleep(300);
                        instance = new SychronLazySingleton();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return instance;
    }
}

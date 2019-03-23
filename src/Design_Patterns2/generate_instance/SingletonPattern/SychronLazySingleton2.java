package Design_Patterns2.generate_instance.SingletonPattern;

class SychronLazySingleton2 {
    private static  SychronLazySingleton2 instance = null;

    private SychronLazySingleton2(){
        System.out.println("产生了一个LazySingleton");
    }

    public static synchronized SychronLazySingleton2 getInstance(){ //直接锁住一个方法，粒度大
        if (instance == null) {
            try {
                Thread.sleep(300);
                instance = new SychronLazySingleton2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}

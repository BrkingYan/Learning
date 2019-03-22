package Design_Patterns2.generate_instance.SingletonPattern;

class SychronLazySingleton4 {
    private static  SychronLazySingleton4 instance = null;

    private SychronLazySingleton4(){
        System.out.println("������һ��LazySingleton");
    }

    public static SychronLazySingleton4 getInstance(){
        if (instance == null) {
            try {
                synchronized (SychronLazySingleton4.class){ //�޷�ͬ��
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

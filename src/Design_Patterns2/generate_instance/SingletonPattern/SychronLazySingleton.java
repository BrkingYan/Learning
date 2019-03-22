package Design_Patterns2.generate_instance.SingletonPattern;

class SychronLazySingleton {
    private static  SychronLazySingleton instance = null;

    private SychronLazySingleton(){
        System.out.println("������һ��LazySingleton");
    }

    public static SychronLazySingleton getInstance(){
        synchronized (SychronLazySingleton.class){ //��ʵҲ����סһ������
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

package Design_Patterns2.generate_instance.SingletonPattern;

class SychronLazySingleton2 {
    private static  SychronLazySingleton2 instance = null;

    private SychronLazySingleton2(){
        System.out.println("������һ��LazySingleton");
    }

    public static synchronized SychronLazySingleton2 getInstance(){ //ֱ����סһ�����������ȴ�
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

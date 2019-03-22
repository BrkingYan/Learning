package Design_Patterns2.generate_instance.SingletonPattern;

public class EagerSingleton {
    private static EagerSingleton singleton = new EagerSingleton();//�̰߳�ȫ���������ܲ���

    private EagerSingleton(){
        System.out.println("������һ������ʵ��");
    }

    public static EagerSingleton getInstance(){

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return singleton;
    }
}

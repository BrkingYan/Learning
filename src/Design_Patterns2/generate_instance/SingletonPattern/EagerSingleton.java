package Design_Patterns2.generate_instance.SingletonPattern;

public class EagerSingleton {
    private static EagerSingleton singleton = new EagerSingleton();//线程安全，但是性能不好

    private EagerSingleton(){
        System.out.println("生成了一个饥饿实例");
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

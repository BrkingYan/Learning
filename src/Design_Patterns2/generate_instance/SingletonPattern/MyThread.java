package Design_Patterns2.generate_instance.SingletonPattern;

public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("eager : " + EagerSingleton.getInstance().hashCode());
        System.out.println("error : " + ErrorSingleton.getInstance().hashCode());
        System.out.println("lazy : " + LazySingleton.getInstance().hashCode());
        System.out.println("sych lazy : " + SychronLazySingleton.getInstance().hashCode());
        System.out.println("sych lazy2 : " + SychronLazySingleton2.getInstance().hashCode());
        System.out.println("sych lazy3 : " + SychronLazySingleton3.getInstance().hashCode());
        System.out.println("sych lazy4 : " + SychronLazySingleton4.getInstance().hashCode());
    }
}

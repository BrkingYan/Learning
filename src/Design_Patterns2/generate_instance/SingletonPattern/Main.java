package Design_Patterns2.generate_instance.SingletonPattern;

public class Main{
    public static void main(String[] args) {

        System.out.println("####################¼¢¶öµ¥Àý####################");
        EagerSingleton object1 = EagerSingleton.getInstance();
        EagerSingleton object2 = EagerSingleton.getInstance();
        if (object1 == object2)
            System.out.println("object1 == object2");
        else
            System.out.println("object1 != object2");


        System.out.println("###################´íÎóµ¥Àý#####################");
        ErrorSingleton object3 = ErrorSingleton.getInstance();
        ErrorSingleton object4 = ErrorSingleton.getInstance();
        if (object3 == object4)
            System.out.println("object3 == object4");
        else
            System.out.println("object3 != object4");


        System.out.println("###################ÀÁººµ¥Àý#####################");
        LazySingleton object5 = LazySingleton.getInstance();
        LazySingleton object6 = LazySingleton.getInstance();
        if (object5 == object6)
            System.out.println("object5 == object6");
        else
            System.out.println("object5 != object6");


        System.out.println("########3#####Thread1#############");
        Thread thread1 = new MyThread();
        thread1.start();
        System.out.println("########3#####Thread2#############");
        Thread thread2 = new MyThread();
        thread2.start();
    }
}

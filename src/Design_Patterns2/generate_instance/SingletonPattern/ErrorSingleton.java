package Design_Patterns2.generate_instance.SingletonPattern;

public class ErrorSingleton {
    private ErrorSingleton(){
        System.out.println("������һ��������");
    }

    public static ErrorSingleton getInstance(){
        return new ErrorSingleton();
    }
}

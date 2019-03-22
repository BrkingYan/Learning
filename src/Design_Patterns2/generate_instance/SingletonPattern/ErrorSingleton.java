package Design_Patterns2.generate_instance.SingletonPattern;

public class ErrorSingleton {
    private ErrorSingleton(){
        System.out.println("生成了一个错误单例");
    }

    public static ErrorSingleton getInstance(){
        return new ErrorSingleton();
    }
}

package ThinkingInJava.Exception;

// 运行时异常不受编译器检查
public class RunTimeEx {
    public static void main(String[] args) {
        RunTimeEx ex = new RunTimeEx();
        ex.b();
    }

    void a(){
        throw new RuntimeException();
    }

    void b(){
        a();
    }
}

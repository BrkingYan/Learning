package ThinkingInJava.Exception.Throws;

public class Throws {
    private Exception exception;
    public static void main(String[] args) {
        Throws t = new Throws();
        try {
            System.out.println("main call c()");
            t.c();
        }catch (Exception e){
            System.out.println(e == t.exception);
        }
    }

    // a() make a exception
    void a() throws Exception{
        System.out.println("a() throw a new Exception");
        exception = new Exception("throw from a()");
        System.out.println("stack trace in a() : ");
        for (StackTraceElement element : exception.getStackTrace()){
            System.out.println(element.getMethodName());
        }
        exception.printStackTrace();
        throw exception;
    }

    void b() throws Exception{
        System.out.println("b() call a()");
        a();
    }

    void c() throws Exception{
        System.out.println("c() call b()");
        b();
    }
}

package ThinkingInJava.Exception.FillInStackTrace;

public class FillInStackTrace {
    private Exception exception1;
    private Exception exception2;
    public static void main(String[] args) {
        FillInStackTrace thiss = new FillInStackTrace();

            System.out.println("main call c()");
            thiss.c();
    }

    // a() make a exception
    void a() throws Exception{
        System.out.println("a() throw Exception1");
        exception1 = new Exception("throw from a()");
        System.out.println("stack trace in a() : ");
        for (StackTraceElement element : exception1.getStackTrace()){
            System.out.println(element.getMethodName());
        }
        exception1.printStackTrace();
        throw exception1;
    }

    void b() throws Exception{
        System.out.println("b() call a()");
        try {
            a();
        } catch (Exception e) {
            System.out.println("exception1 is handled in b()");
            exception2 = new Exception("throw from b()");
            System.out.println("b() throw exception2 when catch exception1");
            System.out.println("exception2's trace in b() : ");
            exception2.printStackTrace();
            throw exception2;
        }
    }

    void c(){
        System.out.println("c() call b()");
        try {
            b();
        } catch (Exception e) {
            System.out.println("exception2's trace in c() : ");
            e.printStackTrace();
        }
    }
}

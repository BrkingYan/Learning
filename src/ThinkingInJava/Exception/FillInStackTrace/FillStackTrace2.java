package ThinkingInJava.Exception.FillInStackTrace;


/*
*  相当于把之前的栈轨迹清除了，原本一个Exception是记得它是从哪一步步被抛出来的，
*  用了FillInStackTrace之后，就不记得之前走过的路了，就把当前位置设为起点了
* */
public class FillStackTrace2 {
    private Exception exception1;
    public static void main(String[] args){
        FillStackTrace2 thiss = new FillStackTrace2();

        System.out.println("main call b()");
        try {
            thiss.b();
        } catch (Exception e) {
            System.out.println("stack trace in main : ");
            e.printStackTrace();
        }
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

    void b() throws Exception {
        System.out.println("b() call a()");
        try {
            a();
        } catch (Exception e) {
            System.out.println("stack trace in b() ");
            e.printStackTrace();
            throw (Exception) e.fillInStackTrace();
        }
    }
}

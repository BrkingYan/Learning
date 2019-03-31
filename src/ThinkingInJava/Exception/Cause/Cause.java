package ThinkingInJava.Exception.Cause;

public class Cause {
    public static void main(String[] args) {
        Cause c = new Cause();
        try {
            c.b();
        } catch (Exception e) {
            System.out.println("print second exception's trace");
            e.printStackTrace();
        }
        System.out.println("------------------------------");

        try {
            c.b1();
        } catch (Exception e) {
            System.out.println("print second exception's trace");
            e.printStackTrace();
        }

    }

    void a() throws NullPointerException {
        throw new NullPointerException();
    }

    void b() throws Exception {
        try {
            a();
        } catch (Exception e) {
            System.out.println("print first exception's trace");
            e.printStackTrace();
            //上一个异常成了新异常的cause
            //Exception类型的异常对象可以直接通过构造器设置Cause
            throw new Exception(e);
        }
    }

    void b1() throws Exception {
        try {
            a();
        } catch (Exception e) {
            System.out.println("print first exception's trace");
            e.printStackTrace();
            //用initCause()将异常连接起来
            IndexOutOfBoundsException e2 = new IndexOutOfBoundsException();
            e2.initCause(e);//把上一个异常当作他的原因
            throw e2;
        }
    }
}

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
            //��һ���쳣�������쳣��cause
            //Exception���͵��쳣�������ֱ��ͨ������������Cause
            throw new Exception(e);
        }
    }

    void b1() throws Exception {
        try {
            a();
        } catch (Exception e) {
            System.out.println("print first exception's trace");
            e.printStackTrace();
            //��initCause()���쳣��������
            IndexOutOfBoundsException e2 = new IndexOutOfBoundsException();
            e2.initCause(e);//����һ���쳣��������ԭ��
            throw e2;
        }
    }
}

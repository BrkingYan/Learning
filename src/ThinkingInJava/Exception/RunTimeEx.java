package ThinkingInJava.Exception;

// ����ʱ�쳣���ܱ��������
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

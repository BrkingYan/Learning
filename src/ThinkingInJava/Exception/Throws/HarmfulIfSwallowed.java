package ThinkingInJava.Exception.Throws;

public class HarmfulIfSwallowed {
    public static void main(String[] args) {
        HarmfulIfSwallowed t = new HarmfulIfSwallowed();
        t.b();
    }

    void a() {
        try {
            throw new ClassNotFoundException();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);//��������쳣��װ��RuntimeException�п��Է�ֹ�쳣��ʧ
        }
    }

    void b(){
        a();
    }
}

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
            throw new RuntimeException(e);//将检查型异常包装到RuntimeException中可以防止异常消失
        }
    }

    void b(){
        a();
    }
}

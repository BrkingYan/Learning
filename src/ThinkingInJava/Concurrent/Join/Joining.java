package ThinkingInJava.Concurrent.Join;

public class Joining {
    public static void main(String[] args) throws InterruptedException {
        Sleeper sleeper1 = new Sleeper("Sleeper1",1200);//��sleeper���ڱ�����sleep 1500����
        Sleeper sleeper2 = new Sleeper("Sleeper2",1500);
        Joiner joiner1 = new Joiner("joiner1",sleeper1);
        Joiner joiner2 = new Joiner("joiner2",sleeper2);
        joiner1.start();
        joiner2.start();
        Thread.sleep(1300);
        sleeper2.interrupt();//���߳���sleeper2 ��˯��
    }
}

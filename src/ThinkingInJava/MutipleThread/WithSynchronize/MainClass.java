package ThinkingInJava.MutipleThread.WithSynchronize;

public class MainClass
{

    public static void main(String[] args)
    {
        // 创建10个线程来调用【同一个】TestForSynchronized实例(对象)
        TestForSynchronized temp=new TestForSynchronized();
        for(int index=0;index<10;index++)
        {
            MyThread_01 thread=new MyThread_01(temp);
            thread.start();
        }
    }
}



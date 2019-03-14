package ThinkingInJava.MutipleThread.WithoutSynchronize;

/*
* 该例子用于展示没加锁时，多线程的运行状况
* */
public class ThreadIntroduction {

    public static void main(String[] args)
    {
        for(int index=0;index<3;index++)
        {
            MyThread temp=new MyThread();
            temp.start();
        }
    }
}


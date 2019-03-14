package ThinkingInJava.MutipleThread.WithSynchronize;

class MyThread_01 extends Thread
{
    TestForSynchronized testObject;

    public  MyThread_01(TestForSynchronized testObject)
    {
        this.testObject=testObject;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(0);
        } catch (InterruptedException e)
        {

            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"--"+testObject.commonMethod());
        System.out.println(Thread.currentThread().getName()+"--"+testObject.setID_01());
    }
}


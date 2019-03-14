package ThinkingInJava.MutipleThread.WithSynchronize;

class TestForSynchronized
{
    static int ID=0;

    /*
    * synchronized块具有以下特点：
    * 1、synchronized块必须获得了syncObject的锁才能执行这块代码，具体获得锁的机制如前面分析；
    * 2、当多个线程并发访问某个实例syncObject的synchronized(this)块时，任何一个时刻只有一个线程能够持有该实例的锁，执行synchronized(this)块，其它线程将被阻塞，直到执行完毕释放锁；
    * 3、多线程场景下，当某个线程访问实例syncObject的synchronized(this)块时，其它线程可以访问实例syncObject的非synchronized(this)块和非synchronized方法；
    * */
    //测试方法01-synchronized块(对象级)
    public String setID_01()
    {
        synchronized(this)
        {
            ID++;
            return "setID_01() ID No.:"+ID;
        }
    }

    //测试方法02-synchronized块(类级别)，synchronized块必须获得了syncObject的锁才能执行这块代码
    /*
    * 这里并不是this(对象级),而是class(类级别),相较于对象级别，类级别具有更严格的同步约束，主要有以下几点：

    * 1、前已述及，采用了synchronized机制的类，其每一个实例都有一个锁(对象级别的锁)，事实上，类也有唯一的锁，换言之，采用了synchronized机制的类有一个类锁；
    * 2、多线程场景下，当某一线程获得类锁(注意：不再是对象锁)，其它线程将被阻塞，将无法调用或访问该类的所有方法和域，包括静态方法和静态变量；
    * 3、对于含有静态方法和静态变量的代码块的同步，类锁的严格约束在多线程场景下非常实用，应用也较多

    * */
    public String setID_02()
    {
        synchronized(TestForSynchronized.class)
        {
            ID++;
            return "setID_02() ID No.:"+ID;
        }
    }

    //测试方法03-synchronized 方法
    public synchronized String setID_03()
    {
        ID++;
        return "setID_03() ID No.:"+ID;
    }

    //普通方法，多个线程可以同时访问
    public  String commonMethod()
    {
        return "commonMethod ID No."+ID;
    }
}

//线程对实例锁的释放时刻为：synchronized块执行完毕或者synchronized方法返回
//还有一个互斥锁mutex
//由于mutex为静态类型，对于TestForSynchronized类的所有对象，当需要访问TestMethod的同步块时都必须获得mutex对象的锁，
// 然而，mutex属于类，有且仅有一个锁，从而可以保证任意一个时刻只有一个线程可以访问这个同步块。
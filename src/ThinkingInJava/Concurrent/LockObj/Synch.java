package ThinkingInJava.Concurrent.LockObj;

class Synch {
    private Object syncObj = new Object();
    synchronized void f(){
        for (int i = 0;i<5;i++){
            System.out.println("f()");
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " over");
    }

    void g(){
        synchronized (syncObj){
            for (int i = 0;i<5;i++){
                System.out.println("g()");
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + " over");
        }
    }

    void a(){
        synchronized (syncObj){
            for (int i = 0;i<5;i++){
                System.out.println("a()");
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + " over");
        }
    }

    synchronized void b(){
        for (int i = 0;i<5;i++){
            System.out.println("b()");
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " over");
    }
}

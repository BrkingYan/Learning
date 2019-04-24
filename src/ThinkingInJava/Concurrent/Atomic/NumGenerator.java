package ThinkingInJava.Concurrent.Atomic;

/*
*  产生共享数据
* */
class NumGenerator  {
    private static volatile int number = 0;
    static int nextNumber(){
        return number++;     //非原子操作
    }
    /*
    * 虽然volatile可以保证number被修改之后立即写入内存
    * 但是nextNumber()方法是不同步的，
    * 其他线程
    * */
}

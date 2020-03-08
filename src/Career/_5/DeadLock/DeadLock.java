package Career._5.DeadLock;

import org.omg.CORBA.OBJ_ADAPTER;

public class DeadLock {
    private Object a = new Object();
    private Object b = new Object();

    public void func1(){
        synchronized (a){
            synchronized (b){

            }
        }
    }

    public void func2(){
        synchronized (b){
            synchronized (a){

            }
        }
    }
}

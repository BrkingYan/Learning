package ThinkingInJava.Concurrent.compare;

class NumManager2 extends NumManager {

    /*
     *  如果Number不同步，这个方法同步也没有用
     *  因为该类最终还是要访问Number
     * */
    void increment(){
        synchronized (this){
            number.increment();
        }
    }

}

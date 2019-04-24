package ThinkingInJava.Concurrent.compare;

class NumManager1 extends NumManager {

    /*
    *  如果Number不同步，这个方法同步也没有用
    * */
    void increment(){
        number.increment();
    }


}

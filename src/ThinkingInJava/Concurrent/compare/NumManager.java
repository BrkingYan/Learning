package ThinkingInJava.Concurrent.compare;

abstract class NumManager {
    protected Number number = new Number(0,0);
    abstract void increment();
    Number getNumber(){
        return number;
    }

}

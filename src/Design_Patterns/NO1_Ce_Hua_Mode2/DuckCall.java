package Design_Patterns.NO1_Ce_Hua_Mode2;

public class DuckCall  {

    CallBehavior callBehavior;

    DuckCall(){
        callBehavior = new ZhiZhiCall();
    }

    public void performDuckCall(){
        callBehavior.call();
    }

    public void setCallBehavior(CallBehavior cb){
        callBehavior = cb;
    }

    public void display(){
        System.out.println("this is a duck call tool");
    }

}

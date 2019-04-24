package ThinkingInJava.Concurrent.compare;


//共享资源
/*
*  该类中的方法必须同步，因为其他类最终都会调用该类的方法
* */
class Number {
    volatile private int x;
    volatile private int y;
    Number(int x,int y){
        this.x = x;
        this.y = y;
    }

    void increment(){
        x++;
        y++;
    }

    public String toString(){
        return "X : " + x + " Y : " + y;
    }

    synchronized void checkState(){
        if (x != y){
            throw new RuntimeException("x != y " + "x : " + x + " y : " + y + " Thread : " + Thread.currentThread().getName());
        }
    }
}

package ThinkingInJava.Concurrent.compare;


//������Դ
/*
*  �����еķ�������ͬ������Ϊ���������ն�����ø���ķ���
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

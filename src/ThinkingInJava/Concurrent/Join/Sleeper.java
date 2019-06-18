package ThinkingInJava.Concurrent.Join;


/*
*  һ�����Բ��͵������̵߳��߳�
*  ��join�������̣߳������̱߳������˯��ʱ����ܼ���ִ��
* */
class Sleeper extends Thread {
    private int duration;

    Sleeper(String name,int sleepTime){
        super(name);
        this.duration = sleepTime;
        start();
    }

    Sleeper(String name){
        super(name);
    }
    @Override
    public void run() {
        try {
            sleep(duration);
            if (!isInterrupted()){
                System.out.println(getName() + " ˯����...");
            }
        } catch (InterruptedException e) {
            //System.err.println(getName() + " was interrupted " + " isInterrupted() " + isInterrupted());
            System.err.println(getName() + " ��;��������");
            Thread.currentThread().interrupt();
        }
        System.out.println(getName() + " ˯����");
    }
}

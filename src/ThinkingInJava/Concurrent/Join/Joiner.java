package ThinkingInJava.Concurrent.Join;


import java.util.concurrent.atomic.AtomicInteger;

/*
*  ���̳߳���һ��Sleeper�̣߳�
*  ���Ե���sleeper��join()��������sleeper����˯������ʱ��
* */
class Joiner extends Thread {
    private Sleeper sleeper;

    Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
    }

    @Override
    public void run() {
        try {
            System.out.println(sleeper.getName() + " ����˯����");
            sleeper.join();//Joiner�ȴ�sleeper�����ż���ִ��
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        //System.out.println(getName() + " join completed");
    }
}

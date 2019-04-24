package ThinkingInJava.Concurrent.Join;


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
            System.err.println("Interrupted");
        }
        //System.out.println(getName() + " join completed");
    }
}

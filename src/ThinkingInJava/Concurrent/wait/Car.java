package ThinkingInJava.Concurrent.wait;

class Car {
    private boolean waxOn = false;

    //������ɣ�֪ͨ�����߳�
    synchronized void waxed(){
        waxOn = true;
        notifyAll();
    }

    //ȥ����ɣ�֪ͨ�����߳�
    synchronized void buffed(){
        waxOn = false;
        notifyAll();//�����ڴ˶���������ϵȴ��������߳�
    }

    //�ȴ�����
    synchronized void waitForWax() throws InterruptedException {
        while (waxOn == false){
            wait();//wait()�������ͷ��������õ�ǰ�߳��ڴ˴�����
        }
    }
    //�ȴ�ȥ��
    synchronized void waitForBuff() throws InterruptedException {
        while (waxOn == true){
            wait();
        }
    }
}

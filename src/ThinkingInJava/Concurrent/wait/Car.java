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
        notifyAll();
    }

    //�ȴ�����
    synchronized void waitForWax() throws InterruptedException {
        while (waxOn == false){
            wait();
        }
    }
    //�ȴ�ȥ��
    synchronized void waitForBuff() throws InterruptedException {
        while (waxOn == true){
            wait();
        }
    }
}

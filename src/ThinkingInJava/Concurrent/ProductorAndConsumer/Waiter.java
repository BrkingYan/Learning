package ThinkingInJava.Concurrent.ProductorAndConsumer;

class Waiter implements Runnable{

    private Restaurant restaurant;

    Waiter(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        System.out.println("waiter run()");
        try {
            while (!Thread.interrupted()){
                synchronized (this){//��ȡwaiter������
                    while (restaurant.meal == null){
                        System.out.println("no food , waiter is waiting");
                        Thread.sleep(200);
                        wait();//��ִ�и�������߳̽���ȴ�״̬����������waiter���̣߳������ڴ˴���ͣ�������Ѻ�ż���ִ��
                        // ���ͷ�waiter������������ͣһͣ���Ұ��������������һ��
                    }
                }
                System.out.println("waiter get " + restaurant.meal);
                synchronized (restaurant.chef){//��ȡchef������
                    restaurant.meal = null;  //�ı�����
                    restaurant.chef.notifyAll();//�������еȴ�chef��������
                }
            }
        }catch (InterruptedException e){
            System.out.println("waiter interrupted");
        }
    }
}

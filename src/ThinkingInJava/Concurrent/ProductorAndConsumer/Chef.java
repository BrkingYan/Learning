package ThinkingInJava.Concurrent.ProductorAndConsumer;

import java.util.concurrent.TimeUnit;

class Chef implements Runnable {

    private Restaurant restaurant;
    private int mealCount;

    Chef(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        System.out.println("chef run()");
        try {
            while (!Thread.interrupted()){
                synchronized (this){//��ȡchef������
                    /*
                    * ���waiter��û��meal����ȥ�����Ȱ����������Լ��ȵȣ�����ȥ����meal
                    * */
                    while (restaurant.meal != null){
                        System.out.println("has food , chef is waiting");
                        wait();//��ִ�и�������߳̽���ȴ�״̬����������Chef���߳�
                    }
                }
                if (++mealCount == 10){
                    System.out.println("sell out");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("order up! ");
                synchronized (restaurant.waiter){ //��ȡwaiter�����������ܻ�����һ�ᣬҪ��wait()�����ͷ�waiter������֮�����
                    restaurant.meal = new Meal(mealCount);
                    restaurant.waiter.notifyAll();//�������еȴ�waiter���������̣߳������ˣ����������߳�
                }
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("chef interrupted");
        }
    }
}

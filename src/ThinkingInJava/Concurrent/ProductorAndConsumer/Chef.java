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
                synchronized (this){//获取chef对象锁
                    /*
                    * 如果waiter还没把meal交出去，就先把锁给他，自己先等，让他去交出meal
                    * */
                    while (restaurant.meal != null){
                        System.out.println("has food , chef is waiting");
                        wait();//让执行该任务的线程进入等待状态，就是驱动Chef的线程
                    }
                }
                if (++mealCount == 10){
                    System.out.println("sell out");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("order up! ");
                synchronized (restaurant.waiter){ //获取waiter对象锁，可能会阻塞一会，要等wait()方法释放waiter对象锁之后才行
                    restaurant.meal = new Meal(mealCount);
                    restaurant.waiter.notifyAll();//唤醒所有等待waiter对象锁的线程，用完了，还给别人线程
                }
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("chef interrupted");
        }
    }
}

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
                synchronized (this){//获取waiter对象锁
                    while (restaurant.meal == null){
                        System.out.println("no food , waiter is waiting");
                        Thread.sleep(200);
                        wait();//让执行该任务的线程进入等待状态，就是驱动waiter的线程，让其在此处暂停，被唤醒后才继续执行
                        // 并释放waiter对象锁，你先停一停，我把锁借给别人先用一阵
                    }
                }
                System.out.println("waiter get " + restaurant.meal);
                synchronized (restaurant.chef){//获取chef对象锁
                    restaurant.meal = null;  //改变条件
                    restaurant.chef.notifyAll();//唤醒所有等待chef锁的任务
                }
            }
        }catch (InterruptedException e){
            System.out.println("waiter interrupted");
        }
    }
}

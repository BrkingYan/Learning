package ThinkingInJava.Concurrent.ProductorAndConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();

    Waiter waiter = new Waiter(this);
    Chef chef = new Chef(this);
    Restaurant(){
        exec.execute(waiter);
        exec.execute(chef);
    }


    public static void main(String[] args) {
        new Restaurant();
    }
}

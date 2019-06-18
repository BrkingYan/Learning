package ThinkingInJava.Concurrent.MessageQueue;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;

class Test {
    public static void main(String[] args) {
        ActiveObject activeObject = new ActiveObject();
        List<Future<?>> results = new CopyOnWriteArrayList<>();

        for (float f = 0.0f;f < 1.0f;f +=0.2f){
            results.add(activeObject.calculateFloat(f,f));
        }

        for (int f = 0;f < 5;f +=1){
            results.add(activeObject.calculateInt(f,f));
        }

        while (results.size() > 0){
            for (Future<?> f : results){
                if (f.isDone()){
                    try {
                        System.out.println("got from queue: " + f.get() + " time: " + System.currentTimeMillis());
                        System.out.println("jjj");
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                    results.remove(f);
                }
            }
        }
        activeObject.shutdown();
    }
}

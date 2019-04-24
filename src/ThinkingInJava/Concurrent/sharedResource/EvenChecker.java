package ThinkingInJava.Concurrent.sharedResource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class EvenChecker implements Runnable {

    private IntGenerator generator;
    private final int id;
    private EvenChecker(IntGenerator generator, int id){
        this.generator = generator;
        this.id = id;
    }
    @Override
    public void run() {
        /*
        * ÿ��EvenChecker�������Ǽ��generator�Ƿ����������
        * */
        while (!generator.isCanceled()){
            int val = generator.next();
            if (val % 2 != 0){
                System.out.println(val + " not even!");
                generator.cancel();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(val);
        }
    }

    private static void test(IntGenerator generator, int numOfGenerator){
        System.out.println("Press COntrol-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        //������ִ��10��EvenChecker����
        for (int i = 0;i<numOfGenerator;i++){
            exec.execute(new EvenChecker(generator,i));
        }
        exec.shutdown();
    }

    static void test(IntGenerator generator){
        test(generator,10);
    }
}

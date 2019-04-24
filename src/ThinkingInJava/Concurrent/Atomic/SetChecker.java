package ThinkingInJava.Concurrent.Atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SetChecker {

    private static MySet set = new MySet(1000);


    static class NumberChecker implements Runnable{
//���񣬼�������еĹ��������Ƿ����ظ�
        @Override
        public void run() {
            while (true){
                int number = NumGenerator.nextNumber();//crush
                if (set.contains(number)){
                    System.out.println("Duplicate : " + number);
                    System.exit(0);
                }
                set.add(number);
            }
        }
    }
}

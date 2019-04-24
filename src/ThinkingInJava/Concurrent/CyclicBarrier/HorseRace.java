package ThinkingInJava.Concurrent.CyclicBarrier;

import java.util.*;
import java.util.concurrent.*;

class HorseRace {
    private static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    HorseRace(int nHorses,final int pause){
        //����һ���µ� CyclicBarrier�������ڸ��������Ĳ����ߣ��̣߳����ڵȴ�״̬ʱ������
        // �������� barrier ʱִ�и��������ϲ������ò��������һ������ barrier ���߳�ִ�С�
        //���������е���֮�󣬼����е�������һ��֮�󣬽�ִ�����ṩ�� Runnable ���ϲ���
        barrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder s = new StringBuilder();
                for (int i = 0;i<FINISH_LINE;i++)
                    s.append("=");
                System.out.println(s);
                for (Horse horse : horses)
                    System.out.println(horse.tracks());
                for (Horse horse : horses){
                    if (horse.getStrides() >= FINISH_LINE){
                        System.out.println(horse + " won!");
                        exec.shutdownNow();
                        return;
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                }catch (InterruptedException e){
                    System.out.println("barrier-action sleep interrupted");
                }
            }
        });
        for (int i = 0;i<nHorses;i++){
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }
}

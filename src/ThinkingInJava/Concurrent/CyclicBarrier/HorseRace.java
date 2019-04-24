package ThinkingInJava.Concurrent.CyclicBarrier;

import java.util.*;
import java.util.concurrent.*;

class HorseRace {
    private static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    HorseRace(int nHorses,final int pause){
        //创建一个新的 CyclicBarrier，它将在给定数量的参与者（线程）处于等待状态时启动，
        // 并在启动 barrier 时执行给定的屏障操作，该操作由最后一个进入 barrier 的线程执行。
        //处理完所有的行之后，即所有的马都迈出一步之后，将执行所提供的 Runnable 屏障操作
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

package ThinkingInJava.Concurrent.CyclicBarrier;

import java.util.HashMap;

class Test {
    public static void main(String[] args) {
        int nHorses= 7;
        int pause = 200;
        new HorseRace(nHorses,pause);

    }
}

package ThinkingInJava.Concurrent.CyclicBarrier;

class Test {
    public static void main(String[] args) {
        int nHorses= 7;
        int pause = 200;
        new HorseRace(nHorses,pause);
    }
}

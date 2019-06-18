package ConcurrentInPractice;

class Task implements Runnable {


    @Override
    public void run() {
        System.out.println(Tester.holder.getN() == 47);
    }
}

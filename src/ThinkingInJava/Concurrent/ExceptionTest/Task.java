package ThinkingInJava.Concurrent.ExceptionTest;

class Task implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                Thread.sleep(100);
                System.out.println("123");
            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
            //Thread.currentThread().interrupt();
        }
    }
}

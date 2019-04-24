package ThinkingInJava.Concurrent.CatchException;

class ExceptionThread extends Thread {
    @Override
    public void run() {
        System.out.println("******** message in exception thread ********");
        Thread thread = Thread.currentThread();
        System.out.println("run() by " + thread);
        System.out.println("“Ï≥£¥¶¿Ì∆˜: " + thread.getUncaughtExceptionHandler());
        System.out.println("******** message in exception thread ********");
        System.out.println();
        throw  new RuntimeException();
    }
}

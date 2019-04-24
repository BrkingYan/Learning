package ThinkingInJava.Concurrent.CatchException;

class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("********** message from exception handler ***********");
        System.err.println("exception handler: " + "catch " + e);
        e.printStackTrace();
        System.out.println("********** message from exception handler ***********");
        System.out.println();
    }

    @Override
    public String toString() {
        return "yy's “Ï≥£¥¶¿Ì∆˜";
    }
}

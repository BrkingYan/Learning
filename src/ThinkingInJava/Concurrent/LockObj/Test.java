package ThinkingInJava.Concurrent.LockObj;


public class Test  {
    public static void main(String[] args) {
        final Synch synch = new Synch();
        new Thread(){
            public void run(){
                synch.a();
            }
        }.start();

        /*try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        synch.b();



        /*new Thread(){
            public void run(){
                while (true){
                    System.out.println("jjjj");
                }
            }
        }.start();*/
    }
}

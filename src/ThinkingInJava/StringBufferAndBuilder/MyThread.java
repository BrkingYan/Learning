package ThinkingInJava.StringBufferAndBuilder;

public class MyThread extends Thread{

    StringBuffer buffer;
    StringBuilder builder;

    public MyThread(){
        buffer = new StringBuffer();
        builder = new StringBuilder();
    }


    @Override
    public void run() {
        super.run();
        buffer.append("1");
        System.out.println("1th buffer" + buffer.toString());
        buffer.append("2");
        System.out.println("2th buffer" + buffer.toString());
        builder.append("1");
        System.out.println("1th builder" + builder.toString());
        builder.append("2");
        System.out.println("2th builder" + builder.toString());
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.start();
        MyThread thread2 = new MyThread();
        thread2.start();
    }
}

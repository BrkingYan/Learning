package ThinkingInJava.Concurrent.CatchException;

import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory {
    /*
    *  ThreadFactory��һ���߳̽���һ������
    *  ���������� (���������������߳�������һ���쳣�����������ڲ�����߳��׳����쳣)
    *  ������Ӷ�����Ϣ�ȵ�
    * */
    @Override
    public Thread newThread(Runnable r) {
        System.out.println("********** message from handler factory ***********");
        System.out.println(this + " creating new handler Thread");
        Thread thread = new Thread(r);
        System.out.println("created " + thread);
        //�����������ڲ���ʵ��
        thread.setUncaughtExceptionHandler(new ExceptionHandler());//���̼߳����쳣����������������̨����һЩ������Ϣ
        System.out.println("---has created a exception handler--: " + thread.getUncaughtExceptionHandler());
        System.out.println("********** message from handler factory ***********");
        System.out.println();
        return thread;
    }
}

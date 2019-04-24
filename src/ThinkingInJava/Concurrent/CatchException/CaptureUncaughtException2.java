package ThinkingInJava.Concurrent.CatchException;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*  setDefaultUncaughtExceptionHandler

*  ���ַ�ʽ����ͨ��ThreadFactory��Thread����ExceptionHandler�ģ�
*  ����ֱ��ͨ��Thread�ľ�̬�������ã��������õĻ�������Thread���ᱻ�������Handler��
*  ����Ϊĳ��Threadͨ��Factory������ר�е�Handler
* */
public class CaptureUncaughtException2 {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
        exec.shutdown();
    }
}

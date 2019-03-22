package CrazyJava.IO.File.ByteStream;

import java.io.*;

public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        long startTime=System.nanoTime();
        FileInputStream fis = new FileInputStream("F:\\fileTest\\1.zip");
        BufferedInputStream bfis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("F:\\fileTest\\2.zip");
        BufferedOutputStream bfos = new BufferedOutputStream(fos);
        byte[] bytes = new byte[1024];
        int num;
        while ((num = bfis.read(bytes)) != -1){
            bfos.write(bytes,0,num);
        }
        bfis.close();
        bfos.close();
        long endTime=System.nanoTime();
        System.out.println("Run time : "+(endTime-startTime)+"ns");
    }
}

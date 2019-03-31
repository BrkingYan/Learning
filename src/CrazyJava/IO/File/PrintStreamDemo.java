package CrazyJava.IO.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {
    public static void main(String[] args){

        try (FileOutputStream fos = new FileOutputStream("F:\\fileTest\\1.txt");
             PrintStream ps = new PrintStream(fos))
        {
            //ps.println(new PrintStreamDemo());
            ps.println("12312rdsfdsf");//直接打印到指定文件中
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

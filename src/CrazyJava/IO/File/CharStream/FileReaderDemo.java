package CrazyJava.IO.File.CharStream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        long startTime=System.nanoTime();
        FileReader fr = new FileReader("F:\\fileTest\\1.txt");
        BufferedReader bfr = new BufferedReader(fr);
        String line;
        while ((line = bfr.readLine()) != null){
            System.out.println(line);

        }
        long endTime=System.nanoTime();
        bfr.close();
        System.out.println("Run time : "+(endTime-startTime)+"ns");
    }
}

package CrazyJava.IO.File.FileReaderAndWriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("E:\\testDir\\hello.txt");
        MyBufferedReader bfr = new MyBufferedReader(fr);
        /*char ch = (char) bfr.myRead();
        System.out.println(ch);
        char ch2 = (char) bfr.myRead();
        System.out.println(ch2);
        bfr.myFlush();*/

        String line;
        while ((line = bfr.myReadLine()) != null){
            System.out.println(line);
        }
        bfr.myClose();
    }
}

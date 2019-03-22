package CrazyJava.IO.File.CharStream;

import java.io.*;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("F:\\fileTest\\1.txt");
        BufferedReader bfr = new BufferedReader(fr);
        FileWriter fw = new FileWriter("F:\\fileTest\\2.txt");
        BufferedWriter bfw = new BufferedWriter(fw);

        String line;
        while ((line = bfr.readLine()) != null){
            bfw.write(line);
            //bfw.newLine();
        }
        bfr.close();
        bfw.close();
    }
}

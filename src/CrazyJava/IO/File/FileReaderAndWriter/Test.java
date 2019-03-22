package CrazyJava.IO.File.FileReaderAndWriter;

import java.io.*;

public class Test {
    public static void main(String[] args){
        FileReader fr = null;
        BufferedReader bfr = null;
        FileWriter fw = null;
        BufferedWriter bfw = null;
        try {
            fr = new FileReader("E:\\testDir\\hello.txt");
            fw = new FileWriter("E:\\testDir\\hello1.txt");
            bfr = new BufferedReader(fr);
            bfw = new BufferedWriter(fw);

            String line;
            //读一行，写一行
            while ((line = bfr.readLine()) != null){
                bfw.write(line);
                bfw.newLine();
                bfw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bfr != null)
                    bfr.close();
                if (bfw != null)
                    bfw.close();
            } catch (IOException e) {

            }
        }


    }
}

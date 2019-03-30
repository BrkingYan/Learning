package ThinkingInJava.IO.File;

import java.io.*;
import java.util.ArrayList;

public class test1 {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {
        /*test1 te = new test1();
        te.writeData();
        te.readData();*/



        FileWriter fw = new FileWriter("newFile2.txt");
        fw.write("asdsd\r\nfgdfdf");
        fw.close();

        /*
        *  若buff的长度足够长，则是一次性读完
        * */
        /*****************************************************/
        char[] buff = new char[1024];
        FileReader fr = new FileReader("newFile2.txt");
        int len;
        while ((len = fr.read(buff)) != -1){
            System.out.println("读到的个数" + len +new String(buff));
        }
        System.out.print(buff[5]);// \r
        System.out.print(buff[6]);// \n
        System.out.print(buff[7]);// f
        fr.close();


        /*
        *  若buff的长度不够长，则是一段一段的读取的
        * */
        /**************************************************/
        /*char[] buff = new char[3];
        FileReader fr = new FileReader("newFile2.txt");
        int charNum;
        while ((charNum = fr.read(buff)) != -1){
            System.out.println("读到的个数 : " + charNum + " " + new String(buff));
        }
        fr.close();*/
    }

    private void writeData(){
        FileWriter fw = null;
        BufferedWriter bfw = null;
        try {
            fw = new FileWriter("newFile.txt");
            bfw = new BufferedWriter(fw);

            /*
            * 方法一：
            * */
            //bfw.write("123" + LINE_SEPARATOR +"45");


            /*
            * 方法二：
            * */
            bfw.write("123");
            //BufferedWriter特有一个newLine()方法
            bfw.newLine();
            bfw.write("abc");
            bfw.append("\r\nhahahaha");


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bfw != null){
                    bfw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("输入流关闭失败");
            }
        }
    }

    private void readData(){
        FileReader fr = null;
        BufferedReader bfr = null;
        try {
            fr = new FileReader("newFile.txt");
            bfr = new BufferedReader(fr);
            String line = null;
            while ((line = bfr.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfr != null){
                try {
                    bfr.close();
                } catch (IOException e) {
                    throw new RuntimeException("输出流关闭失败");
                }
            }
        }
    }
}

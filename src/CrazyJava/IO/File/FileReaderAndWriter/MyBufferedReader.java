package CrazyJava.IO.File.FileReaderAndWriter;

import java.io.FileReader;
import java.io.IOException;

/*
* 装饰者模式：装饰类和被装饰类都必须所属于同一个接口或者父类
* */

public class MyBufferedReader {

    private FileReader fileReader;
    private char[] buff = new char[1024];
    private int charNum = 0;  //定义一个计数器 ， 用于记录缓冲区中的数据个数，如果该数据减为0，就继续从源中获取数据
    private int pos = 0; //定义一个指针，用于指向当前读取的元素

    public MyBufferedReader(FileReader fileReader){
        this.fileReader = fileReader;
    }

    public int myRead() throws IOException {
        //从源中读取数据到缓冲区中
        //只有计数器为0的时候，才需要从源中读取数据
        if (charNum == 0){
            charNum = fileReader.read(buff);
            pos = 0;
        }
        if (charNum == -1)
            return -1;
        //从缓冲区中读取数据
        char ch;
        ch = buff[pos++];
        charNum--;
        return ch;
    }

    public String myReadLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = myRead()) != -1){
            if (ch == '\r')
                continue;
            if (ch == '\n')
                return sb.toString();
            sb.append((char) ch);
        }
        if (sb.length() != 0){
            return sb.toString();
        }
        return null;
    }

    public void myClose() throws IOException {
        fileReader.close();
    }

}

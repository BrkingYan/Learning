package ThinkingInJava.IO.Channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.LongBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[12]);
        System.out.println(buffer.position());
        buffer.asCharBuffer().put("abcdef");//这里数据进来了，但是buffer的position没变，变的是charBuffer的position
        System.out.println(Arrays.toString(buffer.array()));
        System.out.println(buffer.position());

        CharBuffer charBuffer = CharBuffer.wrap(new char[6]);
        charBuffer.put("abcdef");
        System.out.println(charBuffer.position());
        System.out.println(Arrays.toString(charBuffer.array()));



    }
}

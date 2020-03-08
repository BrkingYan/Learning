package ThinkingInJava.IO.Socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        InputStreamReader reader;
        OutputStreamWriter writer;
        BufferedWriter w = null;
        try {
            socket = new Socket("localhost",11111);
            writer = new OutputStreamWriter(socket.getOutputStream());
            w = new BufferedWriter( writer);
            w.write("hello server");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                w.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

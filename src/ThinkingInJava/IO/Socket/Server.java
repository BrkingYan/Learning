package ThinkingInJava.IO.Socket;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        ServerSocket server;
        Socket client;
        InputStreamReader reader;
        OutputStreamWriter writer;
        BufferedReader re ;
        try {
            server = new ServerSocket(11111);
            client = server.accept();
            reader = new InputStreamReader(client.getInputStream());
            re = new BufferedReader(reader);
            String s = re.readLine();
            System.out.println(s);
            writer = new OutputStreamWriter(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

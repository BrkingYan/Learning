package ThinkingInJava.IO.Serializable;

import java.io.*;
import java.util.prefs.Preferences;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LinkedList linkedList = new LinkedList('a',8);
        System.out.println(linkedList);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Serializable.txt"));
        outputStream.writeObject(linkedList);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Serializable.txt"));
        LinkedList list = (LinkedList) inputStream.readObject();
        inputStream.close();
        System.out.println(list);
        System.out.println(linkedList == list);

    }
}

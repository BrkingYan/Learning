package ThinkingInJava.IO.Externalizable;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p = new Person("jack",20);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Person.out"));
        out.writeObject(p);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Person.out"));
        Person pp = (Person) in.readObject();
        in.close();

        System.out.println(pp);
        System.out.println(p == pp);
    }
}

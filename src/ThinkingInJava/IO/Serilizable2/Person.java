package ThinkingInJava.IO.Serilizable2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
    private transient String name;
    private int age;

    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    private void readObject(ObjectInputStream stream) throws IOException,ClassNotFoundException {
        stream.defaultReadObject();//默认的不会去读 transient 变量
        name = (String) stream.readObject();
    }

    private void writeObject(ObjectOutputStream stream) throws IOException,ClassNotFoundException{
        stream.defaultWriteObject();
        stream.writeObject(name);
    }

    @Override
    public String toString() {
        return "Person : " + name + "  age : " + age;
    }
}

package ThinkingInJava.Concurrent.Automic;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.concurrent.atomic.AtomicReference;

public class Singleton {
    private static final AtomicReference<Singleton> instance = new AtomicReference<Singleton>();

    private Singleton() {}

    public static Singleton getInstance() {
        for (;;) {
            Singleton singleton = instance.get();
            if (null != singleton) {
                return singleton;
            }

            singleton = new Singleton();
            if (instance.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s == s2);
    }
}

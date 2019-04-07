package ThinkingInJava.generics.genericsInterface;

class Coffee {
    static long counter = 0;
    final long id = counter++;
    public String toString(){
        return getClass().getSimpleName() + " " + id;
    }
}

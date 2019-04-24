package ThinkingInJava.Concurrent.Atomic;

class MySet  {
    private int[] array;
    private int len;
    private int index = 0;

    MySet(int size){
        array = new int[size];
        len = size;
        for (int i = 0;i<size;i++){
            array[i] = -1;
        }
    }

    synchronized void add(int newVal){
        array[index] = newVal;
        index = ++index % len;
    }

    synchronized boolean contains(int val){
        for (int i = 0;i<len;i++){
            if (array[i] == val){
                return true;
            }
        }
        return false;
    }


}

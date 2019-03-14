package dataStructure.MyArrayList;

import java.util.ArrayList;
import java.util.Iterator;

class MyArrayList<Anytype> implements Iterable<Anytype> {

    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;//当前长度
    private Anytype[] theItems;


    public MyArrayList(){
        doClear();//新创建list的时候，需要先清空原数组
    }

    public void clear(){
        doClear();//清空操作
    }

    //用于清空数组
    public void doClear(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }
    //读取大小
    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    //将list的容量固定为当前元素个数，固定后，再添加元素的话，就是null
    public void trimToSize(){
        ensureCapacity(size());
    }

    //获取角标处的元素
    public Anytype get(int index){
        if (index < 0 || index > size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[index];
    }

    //给指定角标设定新值
    public Anytype set(int index,Anytype newVal){
        if (index < 0 || index > size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        Anytype old = theItems[index];
        theItems[index] = newVal;
        return old;
    }

    //如果添加元素之后，原来的长度不够，则进行扩容
    private void ensureCapacity(int newCapacity){
        if (newCapacity < theSize){
            return;
        }
        Anytype[] old = theItems;//旧数组
        theItems = (Anytype[])new Object[newCapacity];//创建一个更大容量的新数组赋给theItems
        for (int i = 0;i < size();i++){
            theItems[i] = old[i];
        }
    }

    public void add(int index,Anytype x){
        if (theItems.length == size()) //如果数组已经装满了，就将容量翻倍
            ensureCapacity(size() * 2 + 1);
        for (int i = theSize;i > index;i--)
            theItems[i] = theItems[i-1];
        theItems[index] = x;
        theSize ++;
    }


    public boolean add(Anytype x){
        add(size(),x);
        return true;
    }

    //删除指定位置的元素
    public Anytype remove(int index){
        //先找到待删除的元素
        Anytype removeItem = theItems[index];
        //后面的元素前移
        for (int i = index;i < size()-1;i++)
            theItems[i] = theItems[i+1];
        theSize --;
        return removeItem;
    }

    //产生迭代器的方法
    @Override
    public Iterator<Anytype> iterator() {
        return new MyArrayListIterator<Anytype>(this);//使用静态内部类
        //return new MyArrayListIterator();//使用一般内部类(嵌套类)
    }

    //指定list的打印格式
    @Override
    public String toString() {
        String s = "[";
        for (int i = 0;i < theSize;i++) {
            if (i == theSize - 1)
                s = s + theItems[i] + "]";
            else
                s = s + theItems[i] + ",";
        }
        return s;
    }

    //以静态内部类的方式增加迭代器功能
    private static class MyArrayListIterator<Anytype> implements Iterator<Anytype>{
        private int current = 0;
        private MyArrayList<Anytype> theList;//不是默认持有外部类对象，因此必须手动持有

        public MyArrayListIterator(MyArrayList<Anytype> list){
            theList = list;
        }

        @Override
        public boolean hasNext() {
            return current < theList.size();
        }

        @Override
        public Anytype next() {
            return theList.theItems[current++];
        }
    }

    //以内部类的方式增加迭代器功能
    // 默认持有外部类的引用MyArrayList.this
    //因此可以直接使用内部类的成员方法
    private class MyArrayListIterator2<Anytype> implements Iterator<Anytype>{
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public Anytype next() {
            return (Anytype) theItems[current++];
        }

        public void remove(){
            MyArrayList.this.remove(-- current);
        }
    }

}



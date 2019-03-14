package dataStructure.MyLinkedList;

import javafx.scene.AmbientLight;

import java.util.Iterator;
import java.util.LinkedList;

class MyLinkedList<AnyType> implements Iterable<AnyType>{

    private int theSize;
    private int modCount = 0;
    private int expectedModCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;

    public MyLinkedList(){
        doClear();
        beginMarker = new Node<>(null,null,null);
        endMarker = new Node<>(null,beginMarker,null);
        beginMarker.next = endMarker;
        modCount ++;
    }

    private void doClear(){
        theSize = 0;
        modCount = 0;
    }

    /*
    *  提供给外界的方法
    * */
    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return (beginMarker.next == endMarker);
    }

    public boolean add(AnyType x){
        theSize ++;
        add(size(),x);
        return true;
    }

    //在索引index处插入元素x
    public void add(int index,AnyType x){
        //在索引值为index的p的地方插入x
        addBeforeP(getNode(index,0,size()),x);
    }

    //把x插入在p和p.prev之间
    public void addBeforeP(Node<AnyType> p ,AnyType x){
        Node<AnyType> newNode = new Node<>(x,p.prev,p);
        newNode.prev.next = newNode;
        newNode.next = p;
        modCount ++;
        theSize ++;
    }

    //查找索引值为0的节点
    private Node<AnyType> getNode(int index){
        return getNode(index,0,size() - 1);
    }

    //根据index来搜索对应节点，返回链表Node
    // 遍历整个链表，从0到size()范围内查找索引值为index的节点
    private Node<AnyType> getNode(int index,int lower,int upper){
        Node<AnyType> p;
        if (index < lower || index > upper)
            throw new IndexOutOfBoundsException();
        //折半查找
        if (index < size() / 2){
            p = beginMarker.next;
            for (int i = 0;i < index ; i++){
                p = p.next;
            }
        }else {
            p = endMarker;
            for (int i = size() - 1;i > index;i--){
                p = p.prev;
            }
        }
        return p;
    }



    public AnyType get(int index){
        Node<AnyType> p = getNode(index);
        return p.val;
    }

    //将索引值为index处的值修改为newVal
    public AnyType set(int index,AnyType newVal){
        Node<AnyType> p = getNode(index);
        AnyType oldval = p.val;
        p.val = newVal;
        return oldval;
    }

    //移除指定角标处的元素，并返回该元素
    public AnyType remove(int index){
        return remove(getNode(index));
    }

    //删除第一次出现的元素
    public boolean remove(AnyType p){
        for (Node<AnyType> currentNode = beginMarker;currentNode != null;currentNode = currentNode.next){
            if (currentNode.val == p){
                unLink(currentNode);
            }
            break;
        }
        return true;
    }

    //去掉非空节点
    public void unLink(Node x){
        // assert x != null;
        final AnyType element = (AnyType) x.val;
        final Node<AnyType> next = x.next;
        final Node<AnyType> prev = x.prev;

        if (prev == null) {
            beginMarker = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            endMarker = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.val = null;
        theSize--;
        modCount++;
    }


    //直接删除一个节点，并返回该节点的值
    private AnyType remove(Node<AnyType> p){
        p.prev.next = p.next;
        p.next.prev = p.prev;
        theSize --;
        modCount ++;
        return p.val;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new MyLinkedListIterator<>();
    }

    private class Node<AnyType>{
        public AnyType val;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        public Node(AnyType val,Node<AnyType> prev,Node<AnyType> next){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    private class MyLinkedListIterator<AnyType> implements Iterator<AnyType>{

        private Node<AnyType> current = (Node<AnyType>)beginMarker.next;
        private int exceptedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public AnyType next() {

            if(modCount != expectedModCount){
                throw new java.util.ConcurrentModificationException();
            }
            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }

            AnyType nextItem = current.val;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        //remove方法在下一次next()方法执行之前，不能再执行
        @Override
        public void remove() {
            if(modCount != expectedModCount)
                throw new java.util.ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();
            MyLinkedList.this.remove(0);
            expectedModCount++;
            okToRemove = false;
        }
    }
    @Override
    public String toString() {
        String s = "[";
        MyLinkedListIterator iterator = new MyLinkedListIterator();
        while (iterator.hasNext()){
            s = s + iterator.next();
        }
        s = s + "]";
        return s;
    }
}

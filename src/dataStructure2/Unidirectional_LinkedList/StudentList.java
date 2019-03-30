package dataStructure2.Unidirectional_LinkedList;


import java.util.Iterator;

class StudentList implements Iterable {
    private Student head;
    private Student tail;
    private int size;


    StudentList(){

    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size == 0;
    }

    void add(Student student){
        if (head == null){
            head = student;
        }
        if (tail != null){
            tail.next = student;
        }
        tail = student;
        size++;
    }

    StudentList addAll(StudentList tailList){
        tail.next = tailList.head;
        return this;
    }

    void remove(Student student){
        if (head.id == student.id){
            head = head.next;
            student = null;
        }else if (tail.id == student.id){
            Student current = head;
            while (current.next != tail){
                current = current.next;
            }
            current.next = null;
            tail = current;
            student = null;
        }else {
            Student current = head;
            while (current.next != student){
                current = current.next;
            }
            current.next = student.next;
            student = null;
        }
        size--;
    }

    void remove(int index){
        if (index >= size){
            throw new IndexOutOfBoundsException("" + index);
        }
        if (index == 0){
            head = head.next;
        }else if (index == size-1){
            Student current = head;
            while (current.next != tail){
                current = current.next;
            }
            current.next = null;
            tail = current.next;
        }else {
            Student current = head;
            while (current.next.id != index+1){
                current = current.next;
            }
            current.next = get(index).next;
        }
        size--;
    }

    Student get(int index){
        Student current = head;
        while (current.id != index+1){
            current = current.next;
        }
        return current;
    }

    //单向链表的反转
    void reverse(){
        Student before;
        Student newHead = null;
        Student newTail = null;
        Student temp = null;
        Student current;

        current = head;
        before = null;
        while (current.next != null){
            temp = before;
            before = current;
            current = current.next;
            before.next = temp;
        }
        current.next = before;
        newHead = current;
        head = newHead;
        Student current2 = head;
        while (current2.next != null){
            current2 = current2.next;
        }
        newTail = current2;
        tail = newTail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Student currentNode = head;
        while (currentNode != null){
            sb.append(currentNode.toString());
            sb.append("\n");
            currentNode = currentNode.next;
        }
        return sb.toString();
    }

    @Override
    public Iterator iterator() {
        return new MyIterator(head);
    }

    private class MyIterator implements Iterator{
        Student current = new Student();
        MyIterator(Student head){
            current.next = head;
        }
        @Override
        public boolean hasNext() {
            return current.next != null;
        }
        @Override
        public Object next() {
            Student temp = current.next;
            current = current.next;
            return temp;
        }
    }
}

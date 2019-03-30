package dataStructure2.RingLinkedList;

/*
*  环形链表的特点是：在任何一点都能到访问到整条链表
* */
class StudentList {
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
        tail.next = head;
        size++;
    }

    StudentList addAll(StudentList tailList){
        tail.next = tailList.head;
        tailList.tail.next = head;
        tail = tailList.tail;
        return this;
    }

    void remove(Student student){
        if (head.id == student.id){
            head = head.next;
            student = null;
            tail.next = head;
        }else if (tail.id == student.id){
            Student current = head;
            while (current.next != tail){
                current = current.next;
            }
            current.next = head;
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
            tail.next = head;
        }else if (index == size-1){
            Student current = head;
            while (current.next != tail){
                current = current.next;
            }
            current.next = head;
            tail = current;
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

    //环形链表的反转
    void reverse(){
        Student temp = null;
        Student newHead;
        Student before = null;
        Student current = head;

        while (current.next != head){
            temp = before;
            before = current;
            current = current.next;
            before.next = temp;
        }
        current.next = before;
        head = current;
        Student current2 = head;
        while (current2.next != null){
            current2 = current2.next;
        }
        tail = current2;
        tail.next = head;
    }

    void printEntireList(Student s){
        Student ss = s;
        while (ss.next != s){
            System.out.println(ss);
            ss = ss.next;
        }
        System.out.println(ss);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Student currentNode = head;
        while (currentNode != tail){
            sb.append(currentNode.toString());
            sb.append("\n");
            currentNode = currentNode.next;
        }
        sb.append(tail.toString());
        sb.append("\n");
        return sb.toString();
    }
}

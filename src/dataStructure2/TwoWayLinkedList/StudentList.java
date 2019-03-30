package dataStructure2.TwoWayLinkedList;

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
            student.prev = tail;
        }
        tail = student;
        size++;
    }

    // assert s is first && not null
    private void upLinkFirst(Student sToBeDiscard){
        head = sToBeDiscard.next;
        if (sToBeDiscard.next == null){
            tail = null;
        }else {
            sToBeDiscard.next.prev = null;
        }
        size--;
    }

    // assert s is last && not null
    private void upLinkLast(Student sToBeDiscard){
        tail = sToBeDiscard.prev;
        if (sToBeDiscard.prev == null){
            head = null;
        }else {
            sToBeDiscard.prev.next = null;
        }
        size--;
    }

    // assert s is in the middle of list && not null
    private void upLinkMid(Student sToBeDiscard){
        sToBeDiscard.prev.next = sToBeDiscard.next;
        sToBeDiscard.next.prev = sToBeDiscard.prev;
        sToBeDiscard = null;
        size--;
    }

    private void upLink(Student sToBeDiscard){
        if (sToBeDiscard == head){
            upLinkFirst(sToBeDiscard);
        }else if (sToBeDiscard == tail){
            upLinkLast(sToBeDiscard);
        }else {
            upLinkMid(sToBeDiscard);
        }
    }

    void remove(Student student){
        upLink(student);
    }

    void remove(int index){
        remove(get(index));
    }

    Student get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException(index+"");
        }
        Student current;
        //在 0 到 size/2之间的话
        if (index < (size >> 1)){
            current = head;
            for (int i = 0;i < index;i++){
                current = current.next;
            }
        }else {
            //在 size/2到size之间
            current = tail;
            for (int i = size-1;i > index;i--){
                current = current.prev;
            }
        }
        return current;
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
}

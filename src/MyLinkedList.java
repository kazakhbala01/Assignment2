import java.util.LinkedList;

public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head; // entry point
    private MyNode<T> tail; // last node
    private int size;

    public MyLinkedList() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public void add(T newItem) {
        MyNode<T> newNode = new MyNode<>(newItem);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
            size++;
        }

    @Override
    public void remove(int index) {

    }

    @Override
    public void clear() {

    }

    public void removeLast(){
        T removedElement=head.data;
        if(head==tail){
            head=tail=null;
        }else{
            head=head.next;
        }
        size--;
        System.out.println("Removed element is: "+removedElement);
        }

        public T get(int index) {
            MyNode<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        MyNode<T> currentNode = head;

        while (currentNode != null) {
            if (currentNode.data.equals(o)) {
                return index;
            }

            currentNode = currentNode.next;
            index++;
        }

        return -1;
    }


    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        MyNode<T> currentNode = tail;

        while (currentNode != null) {
            if (currentNode.data.equals(o)) {
                return index;
            }

            currentNode = currentNode.prev;
            index--;
        }

        return -1;
    }

    @Override
    public void sort() {
        return;
    }

    private static class MyNode<E> {
         MyNode<E> prev;
        E data;
            MyNode<E> next;
            MyNode(E data){
            this.data=data;}
        }}

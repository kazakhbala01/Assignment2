# Assignment2

This is java project of **Almas Amanbay** from **SE-2215** that contains classes MyArrayList and MyLinkedList which are implementations of ArrayList and LinkedList respectively.

# MyList

```java
public interface MyList<T> {
    int size();
    boolean contains(Object o);
    void add(T item);
    void remove(int index);
    void clear();
    T get(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    void sort();
}
```

## Explanation

This is MyList interface that should implement two classes named MyArrayList and MyLinkedList.


# My array list

```java
public class MyArrayList<T> implements MyList<T>{
    private T[] arr;
    private int size;
    MyArrayList(){
        this.arr=(T[]) new Object[5];
        this.size=0;
    }
    public void increaseBuffer(){
        T[] newArr = (T[]) new Object[arr.length*2];
        for(int i=0; i< arr.length; i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }
    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public void add(T item) {
        if(size == arr.length){
            increaseBuffer();
        }
        arr[size++]=item;
    }


    @Override
    public void remove(int index) {
        checkIndex(index);
        for(int i= index + 1; i<size; i++){
            arr[i-1] = arr[i];
        }
        size--;
    }

    public void clear(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) arr[index];
    }

    @Override
    public int indexOf(Object o) {
        return (int)arr[0];
    }

    @Override
    public int lastIndexOf(Object o) {
        return (int)arr[size-1];
    }

    @Override
    public void sort(){
        System.out.println("new sorted array: ");
        for (int i = 0; i < size; i++)
        {
            for (int j = i + 1; j < size; j++)
            {
                T tmp;
                if ((int)arr[i] > (int)arr[j])
                {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            System.out.print(arr[i]+" ");
        }
    }
}
```

## Explanation

This is MyArrayList class.


# MyLinkedList

```java
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
```

## Explanation

This is MyLinkedList class



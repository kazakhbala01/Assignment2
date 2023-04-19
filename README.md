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

    // The underlying array of elements
    private T[] arr;
    // The number of elements in the list
    private int size;

    // Constructor
    MyArrayList(){
        // Initialize the array with a length of 5
        this.arr=(T[]) new Object[5];
        // Initialize the size to 0
        this.size=0;
    }

    // Method to increase the buffer of the array by doubling its length
    public void increaseBuffer(){
        T[] newArr = (T[]) new Object[arr.length*2];
        for(int i=0; i< arr.length; i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }

    // Method to check if an index is within the bounds of the array
    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }

    // Method to get the number of elements in the list
    @Override
    public int size() {
        return size;
    }

    // Method to check if the list contains an object
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    // Method to add an item to the list
    @Override
    public void add(T item) {
        if(size == arr.length){
            // Double the size of the array if it is full
            increaseBuffer();
        }
        // Add the item to the end of the array
        arr[size++]=item;
    }

    // Method to remove an element from the list at the specified index
    @Override
    public void remove(int index) {
        // Check if the index is within the bounds of the array
        checkIndex(index);
        // Shift all elements after the index one position to the left
        for(int i= index + 1; i<size; i++){
            arr[i-1] = arr[i];
        }
        // Decrease the size of the array by 1
        size--;
    }

    // Method to clear the list
    public void clear(){
        // Reset the array to a length of 5 and the size to 0
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    // Method to get an element from the list at the specified index
    @Override
    public T get(int index) {
        // Check if the index is within the bounds of the array
        checkIndex(index);
        // Return the element at the specified index
        return (T) arr[index];
    }

    // Method to get the index of the first occurrence of an object in the list
    @Override
    public int indexOf(Object o) {
        // Return the index of the first element in the array
        return (int)arr[0];
    }

    // Method to get the index of the last occurrence of an object in the list
    @Override
    public int lastIndexOf(Object o) {
        // Return the index of the last element in the array
        return (int)arr[size-1];
    }

    // Method to sort the elements in the list
    @Override
    public void sort(){
        System.out.println("new sorted array: ");
        // Bubble sort algorithm to sort the elements
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

    /**
     * A node in a linked list.
     *
     * @param <E> the type of element stored in this node
     */
    private static class MyNode<E> {
        MyNode<E> prev; // reference to the previous node in the list
        E data; // the element stored in this node
        MyNode<E> next; // reference to the next node in the list

        /**
         * Constructs a new node with the specified element.
         *
         * @param data the element to store in this node
         */
        MyNode(E data) {
            this.data = data;
        }
    }}
```

## Explanation

This is MyLinkedList class



public class MyLinkedList<T> {
    private MyNode<T> head; // entry point
    private MyNode<T> tail; // last node
    private int size;

    public MyLinkedList() {
// head = null; --> these are
// size = 0; --> redundant

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
        private static class MyNode<E> {
            E data;
            MyNode<E> next;
            MyNode(E data){
            this.data=data;}
        }}

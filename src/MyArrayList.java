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
    public void getAll(){
        System.out.println("---");
        for(int i=0;i<size;i++){
            System.out.println(arr[i]);
        }
    }
    public void removeDuplicates(){
        for (int i=0;i<size;i++){
            T dup=arr[i];
            for(int j=i+1;j<size;j++){
                if(dup==arr[j]){
                    remove(j);
                }
            }
        }
    }
}
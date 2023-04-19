public class MyArrayList<T> implements MyList<T>{
    private Object[] arr;
    private int size;
    MyArrayList(){
        this.arr=new Object[5];
        this.size=0;
    }
    public void increaseBuffer(){
        Object[] newArr= new Object[arr.length*2];
        for (int i=0;i<arr.length;i++){
            newArr[i]= arr[i];
        }
        arr=newArr;
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
        this.arr = new Object[5];
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
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                int tmp;
                if ((int)arr[i] > (int)arr[j])
                {
                    tmp = (int)arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            System.out.print(arr[i]+" ");
        }
    }
}

public class MyArrayList{
    private int[] arr;
    private int size;
    MyArrayList(){
        this.arr=new int[5];
        this.size=0;
    }
    public void add(int element){
        if(size == arr.length){
            increaseBuffer();
        }
        arr[size++]=element;
    }
    public void increaseBuffer(){
        int[] newArr= new int[arr.length*2];
        for (int i=0;i<arr.length;i++){
            newArr[i]=arr[i];
        }
        arr=newArr;
    }
}

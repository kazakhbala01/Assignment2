import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MyArrayList<Integer> ms=new MyArrayList<>();
        ms.add(2);
        ms.add(2);
        ms.add(3);
        ms.add(4);
        ms.add(4);
        ms.add(5);
        ms.add(4);
        System.out.println(ms.size());
        ms.removeDuplicates();
        System.out.println(ms.size());
        ms.getAll();
    }
}
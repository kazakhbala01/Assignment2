import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MyArrayList<Integer> ms=new MyArrayList<>();
        ms.add(5);
        ms.add(6);
        ms.add(7);
        ms.add(8);
        ms.add(1);
        System.out.println(ms.size());
    }
}
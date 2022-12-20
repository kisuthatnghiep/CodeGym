package ExceptionAndDebug;

import java.util.Random;
import java.util.Scanner;

public class ArraySimple {
    public Integer[] createRandom(){
        Random random = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("Danh sách phần tử của mảng: ");
        for (int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(100);
            System.out.print(" "+ arr[i]);

        }
        return arr;
    }

    public static void main(String[] args) {
        ArraySimple arraySimple = new ArraySimple();
        Integer[] arr = arraySimple.createRandom();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nNhập vào chỉ số của một phần tử bất kì");
        int x = scanner.nextInt();
        try {
            System.out.println("Giá trị của phần tử có chỉ số "+ x + " là " + arr[x]);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Chỉ số vượt quá giá trị của mảng");
        }
    }
}

package ArrayAndMethod;

import java.util.Scanner;

public class AddArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array_1: ");
        int size_1 = scanner.nextInt();
        int []array_1 = new int[size_1];
        for (int i = 0; i< array_1.length; i++){
            System.out.println("Input element "+(i+1)+" of array_1: ");
            array_1[i] = scanner.nextInt();
        }
        System.out.print("array_1: ");
        for (int i:array_1){
            System.out.print(i+" ");
        }

        System.out.println("\nEnter size of array_2: ");
        int size_2 = scanner.nextInt();
        int []array_2 = new int[size_2];
        for (int i = 0; i < array_2.length; i++){
            System.out.println("Input element "+(i+1)+" of array_2: ");
            array_2[i] = scanner.nextInt();
        }
        System.out.print("array_2: ");
        for (int i:array_2){
            System.out.print(i+" ");
        }
        int[] array_3 = new int[size_1+size_2];
        System.arraycopy(array_1, 0, array_3, 0, array_1.length);
        System.arraycopy(array_2, 0, array_3, array_1.length, array_2.length);
        System.out.print("\narray_3: ");
        for (int i:array_3){
            System.out.print(i+" ");
        }
    }
}

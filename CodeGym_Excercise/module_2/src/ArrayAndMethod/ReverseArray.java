package ArrayAndMethod;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int [] array;
        do {
            System.out.println("Enter a size: ");
            size = scanner.nextInt();
            if (size > 20){
                System.out.println("size does not exceed 20");
            }
        }while (size >20);
        array = new int[size];
        for (int i = 0; i < array.length; i++){
            System.out.println("input element "+(i+1)+" of array:" );
            array[i] = scanner.nextInt();
        }
        System.out.print("Element in array:    ");
        for (int i : array) {
            System.out.print(i + "\t");
        }
        //reverse
        for (int i = 0; i < array.length/2; i++){
            int temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
        System.out.print("\nReverse array:       ");
        for (int i:array){
            System.out.print(i+"\t");
        }
    }
}

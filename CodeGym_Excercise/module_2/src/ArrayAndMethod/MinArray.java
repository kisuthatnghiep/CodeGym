package ArrayAndMethod;

import java.util.Scanner;

public class MinArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Input element "+(i+1)+":");
            array[i] = scanner.nextInt();
        }
        System.out.print("array = [ ");
        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println("]");
        int min = array[0];
        for (int i: array){
            if (min> i){
                min = i;
            }
        }
        System.out.println("\nMin of array is "+min);
    }
}

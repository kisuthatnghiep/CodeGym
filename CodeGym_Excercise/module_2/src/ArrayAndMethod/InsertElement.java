package ArrayAndMethod;

import java.util.Scanner;

public class InsertElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array ={10,9,1,-5,26,79,89,12,46,36,0,0,0};
        System.out.print("array:     ");
        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println("\nEnter a value you want to insert: ");
        int value = scanner.nextInt();
        System.out.println("Enter index of this value: ");
        int index = scanner.nextInt();
        if (index <= -1 || index >= array.length){
            System.out.println("Element can't insert to array");
        }else {
            for (int i = array.length-1; i>index; i--){
                array[i] = array[i-1];
            }
            array[index] = value;
            System.out.print("New array: ");
            for(int i:array){
                System.out.print(i+" ");
            }
        }
    }
}

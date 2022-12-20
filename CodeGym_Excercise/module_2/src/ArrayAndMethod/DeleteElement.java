package ArrayAndMethod;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        int[] array = {1,6,9,3,4,5,10,13,12,19};
        System.out.println("Enter a element: ");
        int deleteElement =scanner.nextInt();
        for (int i = 0; i< array.length; i++){
            if (array[i] == deleteElement){
                index = i;
                break;
            }
        }
        for (int j = index; j<array.length-1; j++){
            array[j] = array [j+1];
        }
        array[array.length-1] = 0;
        System.out.print("New array: ");
        for(int i:array){
            System.out.print(i+" ");
        }
    }
}

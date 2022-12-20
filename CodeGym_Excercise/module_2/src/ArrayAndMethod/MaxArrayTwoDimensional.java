package ArrayAndMethod;

import java.util.Scanner;

public class MaxArrayTwoDimensional {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row size:");
        int size_row = scanner.nextInt();
        System.out.println("Enter a column size:");
        int size_column = scanner.nextInt();
        int[][] array = new int[size_row][size_column];
        for(int i =0; i< array.length; i++){
            for (int j = 0; j<array[i].length; j++){
                System.out.println("Input Element ["+i+"]"+"["+j+"]");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("array = ");
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println("\n");
        }

        int max = array[0][0];
        int index_row = 0;
        int index_column = 0;
        for(int i =0; i< array.length; i++){
            for (int j = 0; j<array[i].length; j++){
                if(max < array[i][j]){
                    max = array[i][j];
                    index_row = i;
                    index_column = j;
                }
            }
        }
        System.out.println("Max of array is "+max+" at row "+index_row+" and column "+index_column);
    }
}

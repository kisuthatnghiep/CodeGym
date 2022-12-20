package ArrayAndMethod;

import java.util.Scanner;

public class SumColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumColumn = 0;
        System.out.println("Enter a row size: ");
        int size_row = scanner.nextInt();
        System.out.println("Enter a column size: ");
        int size_column = scanner.nextInt();
        int[][]array = new int[size_row][size_column];
        for (int i = 0; i < array.length; i++){
            for (int j = 0 ; j < array[i].length; j++){
                System.out.println("Input value of element ["+i+"]["+j+"]");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("array = ");
        for (int[] i:array){
            for (int j:i){
                System.out.print(j+" ");
            }
            System.out.print("\n");
        }
        System.out.println("Input column you want to total: ");
        int column = scanner.nextInt();
        for (int[] ints : array) {
            sumColumn += ints[column];
        }
        System.out.println("Sum of column "+column+" is "+sumColumn);
    }
}

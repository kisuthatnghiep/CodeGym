package ArrayAndMethod;

import java.util.Scanner;

public class MainDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size matrix: ");
        double sumMainDiagonal = 0;
        int size = scanner.nextInt();
        double[][] array = new double[size][size];
        for (int i = 0; i < array.length; i++){
            for ( int j = 0; j < array[i].length; j++){
                System.out.println("Input value of element ["+i+"]["+j+"]");
                array[i][j] = scanner.nextDouble();
            }
        }
        System.out.println("Matrix = ");
        for(double[] i:array){
            for (double j:i){
                System.out.print(j+" ");
            }
            System.out.print("\n");
        }
        for(int i = 0; i < array.length; i++){
            sumMainDiagonal += array[i][i];
        }
        System.out.println("Sum of element in the main diagonal is "+sumMainDiagonal);
    }
}

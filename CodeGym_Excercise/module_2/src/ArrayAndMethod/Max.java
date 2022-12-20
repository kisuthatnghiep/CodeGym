package ArrayAndMethod;

import java.util.Scanner;

public class Max {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double [] property;
        int size;
        do {
            System.out.println("Enter a size: ");
            size = scanner.nextInt();
            if (size > 20){
                System.out.println("size does not exceed 20");
            }
        }while (size > 20);
        property = new double[size];
        for (int i = 0; i< property.length; i++){
            System.out.println("Input property of billionaires "+(i+1)+"(billion USD): ");
            property[i] = scanner.nextDouble();
        }
        System.out.print("property of billionaires: ");
        for (double i:property){
            System.out.print(i+"  ");
        }
        double richest = 0;
        int index = 0;
        for (int i = 0; i < property.length; i++){
            if (property[i] > richest) {
                richest = property[i];
                index = i;
            }
        }
        System.out.println("\nThe largest property is "+richest+" million dollars at position "+index);
    }
}

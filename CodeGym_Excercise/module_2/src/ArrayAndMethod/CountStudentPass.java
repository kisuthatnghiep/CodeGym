package ArrayAndMethod;

import java.util.Scanner;

public class CountStudentPass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of student need to count: ");
        int count = 0;
        int size = scanner.nextInt();
        if (size > 30){
            System.out.println("Amount should not exceed 30");
        }else {
            double[] array = new double[size];
            for (int i = 0; i< array.length; i++){
                System.out.println("Input mark of student "+(i+1));
                array[i] = scanner.nextDouble();
            }
            System.out.print(" list mark of student: ");
            for(double i:array){
                System.out.print(i+" ");
                if (i >= 5){
                    count++;
                }
            }
            System.out.println("\nNumber of student pass the exam is "+count);
        }
    }
}

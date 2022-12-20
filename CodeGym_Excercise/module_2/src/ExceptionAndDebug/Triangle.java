package ExceptionAndDebug;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
        System.out.println("Input a: ");
        double a = scanner.nextDouble();
        System.out.println("Input b: ");
        double b = scanner.nextDouble();
        System.out.println("Input c: ");
        double c = scanner.nextDouble();
        if (a < 0 || b < 0 || c < 0){
            throw new IllegalTriangleException();
        }
        if (a + b < c || a + c < b || b + c < a){
            throw new IllegalTriangleException();
        }
            System.out.println("a, b, c  is 3 side of triangle");
        }
        catch (IllegalTriangleException e) {
            System.err.println("a, b, c is not 3 side of triangle");
        }

        }

}

class IllegalTriangleException extends Exception{

}
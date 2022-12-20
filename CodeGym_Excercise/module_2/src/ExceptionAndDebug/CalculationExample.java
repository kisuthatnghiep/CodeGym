package ExceptionAndDebug;

import java.util.Scanner;

public class CalculationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào giá trị x: ");
        int x = scanner.nextInt();
        System.out.println("Nhập vào giá trị y: ");
        int y = scanner.nextInt();
        calculate(x, y);
    }
    public static void calculate(int x, int y){
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("x + y = "+ a);
            System.out.println("x - y = "+ b);
            System.out.println("x * y = "+ c);
            System.out.println("x / y = "+ d);
        } catch (Exception e){
            System.err.println("Xảy ra ngoại lệ: "+ e.getMessage());
        }
    }
}

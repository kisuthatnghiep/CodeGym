package loop;

import java.util.Scanner;

public class UCLN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number a: ");
        int a = scanner.nextInt();
        System.out.println("Enter number b: ");
        int b = scanner.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 && b == 0){
            System.out.println("No greatest common factor");
        }else if(a == 0 && b != 0){
            System.out.println("UCLN(a,b) = "+b);
        }else if(b == 0 && a != 0) {
            System.out.println("UCLN(a,b) = " + a);
        }else {
            while (a != b) {
                if (a > b) {
                    a = a - b;
                } else b = b - a;
            }
            System.out.println("UCLN(a,b) = " + a);
        }
    }
}

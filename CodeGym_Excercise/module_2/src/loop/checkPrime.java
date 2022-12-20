package loop;

import java.util.Scanner;

public class checkPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        if (number < 2){
            System.out.printf("%d is not a prime",number);
        }
        boolean flag = true;
        for(int i=2;i<=Math.sqrt(number);i++){
             if(number % i == 0){
                 flag = false;
                 break;
             }
        }
        if (flag){
            System.out.printf("%d is a prime",number);
        }else
            System.out.printf("%d is not a prime",number);
    }
}

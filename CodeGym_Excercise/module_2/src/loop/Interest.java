package loop;

import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter investment amount(million): ");
        double money = scanner.nextDouble();
        System.out.println("Enter number of month: ");
        int month = scanner.nextInt();
        System.out.println("Enter Interest(%): ");
        double interestRate = scanner.nextDouble();
        double totalInterest = 0;
        for (int i = 0;i < month;i++){
            totalInterest += money*(interestRate/100)/12;
        }
        System.out.println("Total of interest: "+totalInterest);
    }
}

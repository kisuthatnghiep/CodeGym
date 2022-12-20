package introduction;

import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tiGia = 23000;
        System.out.println("Input USD: ");
        int dollar = scanner.nextInt();
        int vnd = tiGia * dollar;
        System.out.printf("%-20s%s","USD","VND\n");
        System.out.printf("%-20d%d",dollar,vnd);
    }
}

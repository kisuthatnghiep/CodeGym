package loop;

import java.util.Scanner;

public class Displaydraw {
    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 4) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle bottom-left");
            System.out.println("3. Print the square triangle top-right");
            System.out.println("4. Print the square triangle top-left");
            System.out.println("5. Print the square triangle bottom-right");
            System.out.println("6. Print isosceles triangle");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Print the rectangle");
                    System.out.println("Input width: ");
                    int width = scanner.nextInt();
                    System.out.println("Input height: ");
                    int height = scanner.nextInt();
                    for (int i = 0;i < height;i++){
                        for (int j = 0;j < width;j++){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("Print the square triangle bottom-left");
                    System.out.println("Input width: ");
                    width = scanner.nextInt();
                    for (int i = 0; i <= width; i++){
                        for (int j = 0; j < i; j++){
                            System.out.print("*");
                        }
                        for (int k = width; k > i;k--){
                            System.out.print(" ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    System.out.println("Print the square triangle top-right");
                    System.out.println("Input width: ");
                    width = scanner.nextInt();
                        for (int i = 0; i <= width; i++){
                            for (int j = 0; j < i; j++){
                                System.out.print(" ");
                            }
                            for (int k = width; k > i;k--){
                                System.out.print("*");
                            }
                            System.out.print("\n");
                        }
                        break;
                case 4:
                    System.out.println("Print the square triangle top-left");
                    System.out.println("Input width: ");
                    width = scanner.nextInt();
                    for (int i = 0; i <= width; i++){
                        for (int k = width; k > i;k--){
                            System.out.print("*");
                        }
                        for (int j = 0; j < i; j++){
                            System.out.print(" ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 5:
                    System.out.println("Print the square triangle bottom-right");
                    System.out.println("Input width: ");
                    width = scanner.nextInt();
                    for (int i = 0; i <= width; i++){
                        for (int k = width; k > i;k--){
                            System.out.print(" ");
                        }
                        for (int j = 0; j < i; j++){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 6:
                    System.out.println("Print isosceles triangle");
                    System.out.println("Input width: ");
                    width = scanner.nextInt();
                    for (int i=1;i<=width;i++){
                        for (int j=width-i;j>0;j--){
                            System.out.print(" ");
                        }
                        for (int j=1;j<=i;j++){
                            System.out.print("* ");
                        }
                        for (int k=width-i;k>0;k--){
                            System.out.print(" ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }
}

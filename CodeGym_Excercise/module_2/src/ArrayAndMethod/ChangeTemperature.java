package ArrayAndMethod;

import java.util.Scanner;

public class ChangeTemperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double fahrenheit;
        double celsius;
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit ");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Fahrenheit: ");
                    fahrenheit = scanner.nextDouble();
                    System.out.println("Fahrenheit to Celsius: "+fahrenheitToCelsius(fahrenheit));
                    break;
                case 2:
                    System.out.println("Enter Celsius: ");
                    celsius = scanner.nextDouble();
                    System.out.println("celsiusToFahrenheit: "+celsiusToFahrenheit(celsius));
                    break;
                case 0:
                    break;
            }
        }
    }
    public static double celsiusToFahrenheit(double celsius){
        double fahrenheit;
        fahrenheit = 9 / 5.0 * celsius+ 32;
        return  fahrenheit;
    }
    public static double  fahrenheitToCelsius(double fahrenheit){
        double celsius;
        celsius = (5.0 / 9) * (fahrenheit - 32);
        return  celsius;
    }
}

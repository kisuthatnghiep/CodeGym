package introduction;
import java.util.Scanner;
public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'ax + b = c', please enter constants: ");
        System.out.println("a = ");
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        System.out.println("b = ");
        double b = scanner.nextDouble();
        System.out.println("c = ");
        double c = scanner.nextDouble();

        if (a == 0) {
            if (b == c) {
                System.out.println("The solution is all x!");
            } else {
                System.out.println("No solution");
            }
        } else {
            double answer = (c - b)/a;
            System.out.printf("Equation pass with x = %f", answer);
        }
    }
}
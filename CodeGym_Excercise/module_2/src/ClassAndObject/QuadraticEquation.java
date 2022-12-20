package ClassAndObject;

import java.util.Scanner;

public class QuadraticEquation {
    double a;
    double b;
    double c;
    public QuadraticEquation(){

    }

    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant(){
        return Math.pow(b,2)-4*a*c;
    }
    public double getRoot1(){
        if (getDiscriminant() >= 0) {
            return (-b + Math.pow(getDiscriminant(), 0.5))/(2*a);
        }else
            return 0;
    }
    public double getRoot2(){
        if (getDiscriminant() >= 0) {
            return (-b - Math.pow(getDiscriminant(), 0.5))/(2*a);
        }else
            return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Consider the equation: ax2 + bx + c = 0");
        System.out.println("Enter value a: ");
        double a = scanner.nextDouble();
        System.out.println("Enter value b: ");
        double b = scanner.nextDouble();
        System.out.println("Enter value c: ");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        if(quadraticEquation.getDiscriminant() > 0){
            System.out.println("Equation has 2 roots: ");
            System.out.println("x1 = "+quadraticEquation.getRoot1());
            System.out.println("x2 = "+quadraticEquation.getRoot2());
        }else if (quadraticEquation.getDiscriminant() == 0){
            System.out.println("Equation has 1 root: ");
            System.out.println("x = "+quadraticEquation.getRoot1());
        }else
            System.out.println("The equation has no real roots");
    }
}

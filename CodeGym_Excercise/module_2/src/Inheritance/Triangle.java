package Inheritance;

import java.util.Scanner;

public class Triangle {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    private String color = "none";

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3, String color) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.color = color;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter(){
    return getSide1()+getSide2()+getSide3();
    }

    public double getArea(){
        return Math.sqrt(getPerimeter()/2*(getPerimeter()/2-getSide1())*(getPerimeter()/2-getSide2())*(getPerimeter()/2-getSide3()));
    }

    public String toString(){
        return "Triangle has 3 sides of length: "+getSide1()+", "+getSide2()+", "+getSide3()+"." +
                " Perimeter = "+getPerimeter()+", Area = "+getArea()+", color is "+getColor();
    }
}
class TestTriangle{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Triangle triangle = new Triangle();
        System.out.println("Input length of 3 side:");
        System.out.println("Side 1 = ");
        triangle.setSide1(scanner.nextDouble());
        System.out.println("Side 2 = ");
        triangle.setSide2( scanner.nextDouble());
        System.out.println("Side 3 = ");
        triangle.setSide3(scanner.nextDouble());
        scanner.nextLine();
        System.out.println("Enter a color: ");
        triangle.setColor(scanner.nextLine());
        System.out.println(triangle.toString());
    }
}
package ClassAndObject;

import java.util.Scanner;

public class Rectangle {
    double width;
    double height;
    public Rectangle(){

    }
    public Rectangle(double width,double height){
        this.width = width;
        this.height = height;
    }
    public double getArea(){
        return this.width*this.height;
    }
    public double getPerimeter(){
        return (this.width+this.height)*2;
    }
    public String display(){
        return "Rectangle{ width = "+ this.width+", height = "+ this.height+ "}";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a width: ");
        double width = scanner.nextDouble();
        System.out.println("Enter a Height: ");
        double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Your rectangle \n"+ rectangle.display());
        System.out.println("Perimeter of the rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the rectangle: "+ rectangle.getArea());
    }
}

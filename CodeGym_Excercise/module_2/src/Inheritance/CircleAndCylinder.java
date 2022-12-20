package Inheritance;

public class CircleAndCylinder {
private double radius;
private String color;

    public CircleAndCylinder(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public CircleAndCylinder(double radius) {
        this.radius = radius;
    }

    public CircleAndCylinder() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return 3.14*getRadius()*getRadius();
    }

    public String toString(){
        return "A Circle with radius = "+getRadius()+" and area = "+getArea();
    }
}

class Cylinder extends Circle{
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(String color, boolean filled, double radius, double height) {
        super(color, filled, radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return getArea()*getHeight();
    }

    public String toString(){
        return "A cylinder with radius = "+getRadius()+" and volume = "+getVolume();
    }
}

class Main{
    public static void main(String[] args) {
        CircleAndCylinder circle = new CircleAndCylinder(3.5,"green");
        System.out.println(circle.getArea());
        System.out.println(circle.toString());
        Cylinder cylinder = new Cylinder(3.5,8);
        System.out.println(cylinder.getVolume());
        System.out.println(cylinder.toString());
    }
}
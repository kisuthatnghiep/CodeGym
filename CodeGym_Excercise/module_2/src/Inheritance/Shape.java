package Inheritance;

class Shape {
    private String color = "green";
    private boolean filled = true;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public String toString(){
        return "A shape with color of "+getColor()+" and "+(isFilled()?"filled":"not filled");
    }
}
class Rectangle extends Shape{
    private double width = 1;
    private double length = 1;

    public Rectangle(){
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea(){
        return getLength()*getWidth();
    }

    public double getPerimeter(){
        return 2*(getWidth()+getLength());
    }
    public String toString(){
        return "A rectangle with width = " + getWidth() + " and length = " + getLength()+"" +
                ", which is a subclass of" + super.toString();
    }
}

class Circle extends Shape{
    private double radius = 1.0;

    public Circle(){

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return 3.14*getRadius()*getRadius();
    }

    public double getPerimeter(){
        return 2*3.14*getRadius();
    }

    public String toString(){
        return "A Circle with radius = "+getRadius()+", which is a subclass of "+super.toString();
    }
}

class Square extends Rectangle{

    public Square(){
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);

    }

    public Square(double side){
        super(side,side);
    }

    public double getSide(){
        return getWidth();
    }

    public void setSide(double side){
        setLength(side);
        setWidth(side);
    }
    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
}
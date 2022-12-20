package Abstract;

import Inheritance.CircleAndCylinder;

import java.util.Arrays;

public class ComparableCircle extends CircleAndCylinder implements Comparable<ComparableCircle>{
private boolean filled;
    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color);
        this.filled = filled;
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle() {
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public int compareTo(ComparableCircle o) {
        return Double.compare(getRadius(), o.getRadius());
    }
}

class TestComparableCircle{
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(3.5,"red",true);
        circles[1] = new ComparableCircle(-3.5,"red",true);
        circles[2] = new ComparableCircle(0,"red",true);
        System.out.println("Before sort:");
        for(ComparableCircle circle: circles){
            System.out.println(circle.getRadius());
        }
        Arrays.sort(circles);
        System.out.println("After sort:");
        for(ComparableCircle circle: circles){
            System.out.println(circle.getRadius());
        }
    }


}
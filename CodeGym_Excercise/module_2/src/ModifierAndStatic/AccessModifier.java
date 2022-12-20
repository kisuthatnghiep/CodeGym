package ModifierAndStatic;

public class AccessModifier {
    public double radius;
    public String color;

    public AccessModifier() {
        this.radius = 1;
        this.color = "red";
    }

    protected double getRadius() {
        return radius;
    }

    public AccessModifier(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return 3.14*getRadius()*getRadius();
    }
}

    class TestCircle{
        public static void main(String[] args) {
            AccessModifier circle1 = new AccessModifier();
            AccessModifier circle2 = new AccessModifier(4);
            circle2.getArea();
            System.out.println(circle1.getRadius());
            System.out.println(circle1.getArea());
            System.out.println(circle2.getRadius());
            System.out.println(circle2.getArea());
        }
}

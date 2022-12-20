package Abstract;

public interface Colorable {
    void howToColor();
}
class TestColorable{
    public static void main(String[] args) {
        Shape[] shape = new Shape[9];
        shape[0] = new Rectangle(2.5,3.5);
        shape[1] = new Square(4);
        shape[2] = new Circle(3);
        shape[3] = new Rectangle(12.5,13.5);
        shape[4] = new Square(14);
        shape[5] = new Circle(13);
        shape[6] = new Rectangle(22.5,23.5);
        shape[7] = new Square(24);
        shape[8] = new Circle(23);

        for (Shape x:shape){
        if (x instanceof Rectangle){
            System.out.println("Rectangle Area ="+((Rectangle) x).getArea() );
        }
        if (x instanceof Square){
            System.out.println("Square Area ="+((Square) x).getArea() );
            ((Square) x).howToColor();
        }
        if (x instanceof Circle){
            System.out.println("Circle Area ="+((Circle) x).getArea() );
        }
        }
    }
}


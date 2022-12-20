package ModifierAndStatic;

public class Car {
    String name;
    String engine;
    static int count;

    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        count++;
    }
}
class TestPropertyStatic{
    public static void main(String[] args) {
        Car car1 = new Car("Mazda","Skyactiv 3");
        System.out.println(Car.count);
        Car car2 = new Car("Porsche","Skyactiv 6");
        System.out.println(Car.count);
    }
}
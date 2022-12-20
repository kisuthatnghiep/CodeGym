package ClassAndObject;

public class Fan {
    int SLOW = 1;
    int MEDIUM = 2;
    int FAST = 3;
    private boolean on;
    private int speed;
    private double radius;
    private String color;

    public Fan(boolean on, int speed, double radius, String color) {
        this.on = on;
        this.speed = speed;
        this.radius = radius;
        this.color = color;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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
        public Fan(){
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }
    public String toString(){
        if (isOn() == true){
            return "Fan is ON:\nspeed: "+getSpeed()+"\ncolor: "+getColor()+"\nradius: "+getRadius();
        }else
            return "Fan is OFF:\ncolor: "+getColor()+"\nradius: "+getRadius();
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan(true,3,10,"yellow");
        Fan fan2 = new Fan(false,2,5,"blue");
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
    void method(){

    }
}

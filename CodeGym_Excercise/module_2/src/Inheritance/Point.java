package Inheritance;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float[] getXY(){
        return new float[]{getX(),getY()};
    }

    public String toString(){
        return "("+getX()+","+getY()+")";
    }
}

class MovablePoint extends Point{
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint() {
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        this.ySpeed = ySpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        return new float[]{getXSpeed(),getYSpeed()};
    }

    public String toString(){
        return "("+getX()+","+getY()+"),speed = ("+getXSpeed()+","+getYSpeed()+")";
    }

    public MovablePoint move(){
    setXY(getX()+getXSpeed(),getY()+getYSpeed());
    return this;
    }
}

class TestMovePoint{
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(3,5,1,1);
        System.out.println(movablePoint.toString());
        System.out.println(movablePoint.move());
    }
}
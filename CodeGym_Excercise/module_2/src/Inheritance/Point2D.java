package Inheritance;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
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

class Point3D extends Point2D{
    private float z = 0.0f;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z){
        super.setXY(x,y);
        this.z = z;
    }

    public float[] getXYZ(){
        return new float[]{getX(),getY(),getZ()};
    }

    public String toString(){
        return "("+getX()+","+getY()+","+getZ()+")";
    }
}
class PointTest{
    public static void main(String[] args) {
        Point2D point2D = new Point2D(112,246);
        System.out.println(point2D.toString());
        Point3D point3D = new Point3D(23,35,99);
        System.out.println(point3D.toString());
    }
}
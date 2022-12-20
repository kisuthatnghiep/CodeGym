package ModifierAndStatic;

public class Student {
    private int rollNo;
    private String name;
    private static String school ="HUST";

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
    static void changeSchool(){
        school = "CodeGym";
    }
    void display(){
        System.out.println("Roll Number: "+this.rollNo );
        System.out.println("Name: "+this.name );
        System.out.println("School: "+ school);
    }
}
class TestStaticMethod{
    public static void main(String[] args) {
        Student student1 = new Student(1,"Thành");
        Student student2 = new Student(2,"Nam");
        Student student3 = new Student(3,"Lâm");
        student1.display();
        Student.changeSchool();
        student2.display();
    }
}

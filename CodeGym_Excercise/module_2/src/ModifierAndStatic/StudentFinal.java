package ModifierAndStatic;

public class StudentFinal {
    private String name;
    private String classes;

    public StudentFinal() {
        this.name = "John";
        this.classes = "C02";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
class Test{


    public static void main(String[] args) {
        StudentFinal student1 = new StudentFinal();
        StudentFinal student2 = new StudentFinal();
        student1.setName("Thanh");
        student1.setClasses("TĐH-08");
    }
}

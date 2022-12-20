package CollectionFrameWork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Student {
    private String name;
    private int age;
    private String address;

    public Student() {
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString(){
        return "Student name = " + name + ", age = " + age + ", address = " + address;
    }
}

class Main{
    public static void main(String[] args) {
        Student student1 = new Student("Thanh",23,"Ha Dong");
        Student student2 = new Student("Lam",23,"Thanh Xuan");
        Student student3 = new Student("Nam",23,"Nam Tu Liem");
        Map<Integer, Student> mapStudent = new HashMap<>();
        mapStudent.put(1,student1);
        mapStudent.put(2,student2);
        mapStudent.put(3,student3);
        mapStudent.put(1,student3);
        for (Map.Entry<Integer, Student> student: mapStudent.entrySet()){
            System.out.println(student.toString());
        }
        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student2);
        for (Student student: students){
            System.out.println(student.toString());
        }
    }
}
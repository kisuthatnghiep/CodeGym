package CollectionFrameWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student1 implements Comparable<Student1> {
    private String name;
    private int age;
    private String address;

    public Student1(String name, int age, String address) {
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
    @Override
    public int compareTo(Student1 student) {
        return this.getName().compareTo(student.getName());
    }
}

class AgeComparator implements Comparator<Student1>{

    @Override
    public int compare(Student1 o1, Student1 o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class Main2{
    public static void main(String[] args) {
        Student1 student1 = new Student1("Thanh",23,"Ha Dong");
        Student1 student2 = new Student1("Lam",19,"Thanh Xuan");
        Student1 student3 = new Student1("Nam",25,"Nam Tu Liem");
        Student1 student4 = new Student1("Bao",23,"Giai Phong");
        ArrayList<Student1> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        Collections.sort(list);
        for(Student1 student: list){
            System.out.println(student.toString());
        }
        System.out.println("---------------------------------");
        AgeComparator ageComparator = new AgeComparator();
        list.sort(ageComparator);
        for(Student1 student: list){
            System.out.println(student.toString());
        }
    }
}
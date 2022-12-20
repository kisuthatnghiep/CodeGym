package thiModule2;

import java.io.*;
import java.util.*;

public class StudentManager {
    private final ArrayList<Student> students;

    public StudentManager(){
        students = new ArrayList<>();
    }

    public void add(Scanner scanner){
        try {
            System.out.println("input ID: ");
            String id = scanner.nextLine();
            if (id.equals("")){
                throw new InputMismatchException();
            }
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            if (name.equals("")){
                throw new InputMismatchException();
            }
            System.out.println("Enter age:");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter gender:");
            String gender = scanner.nextLine();
            if (gender.equals("")){
                throw new InputMismatchException();
            }
            System.out.println("Enter address:");
            String address = scanner.nextLine();
            if (address.equals("")){
                throw new InputMismatchException();
            }
            System.out.println("Enter average grade:");
            double averageGrade = Double.parseDouble(scanner.nextLine());
            students.add(new Student(id, name, age, gender, address, averageGrade));
        }catch (Exception e){
            System.err.println("Wrong format input!");
        }
    }

    public void display(){
        if (students.isEmpty()){
            System.out.println("There are no students in the list");
        }
        for (Student student: students){
            System.out.println(student.toString());
        }
    }

    public void update(Scanner scanner){
        boolean flag = false;
        try {
            System.out.println("Enter id of student you need to update:");
            String id = scanner.nextLine();
            for (Student student: students){
                if (student.getId().equals(id)){
                    flag = true;
                    System.out.println("Enter new id:");
                    id = scanner.nextLine();
                    if (!id.equals("")) {
                        student.setId(id);
                    }
                    System.out.println("Enter new name:");
                    String name = scanner.nextLine();
                    if (!name.equals("")) {
                        student.setName(name);
                    }
                    System.out.println("Enter new age:");
                    String age = scanner.nextLine();
                    if (!age.equals("")) {
                        student.setAge(Integer.parseInt(age));
                    }
                    System.out.println("Enter new gender:");
                    String gender = scanner.nextLine();
                    if (!gender.equals("")) {
                        student.setGender(gender);
                    }
                    System.out.println("Enter address:");
                    String address = scanner.nextLine();
                    if (!address.equals("")) {
                        student.setAddress(address);
                    }
                    System.out.println("Enter average grade:");
                    String averageGrade = scanner.nextLine();
                    if (!averageGrade.equals("")) {
                        student.setAverageGrade(Double.parseDouble(averageGrade));
                    }
                }
            }
            if (!flag){
                System.err.println("Not found student with this id!");
            }
        }catch (Exception e){
            System.err.println("Wrong format input!");
        }
    }

    public void delete(Scanner scanner){
        boolean flag = false;
        System.out.println("Enter id of student you need to delete:");
        String id = scanner.nextLine();
        for (Student student: students){
            if (student.getId().equals(id)){
                flag = true;
                System.out.println("Are you sure you want to delete it(Y/N)?");
                String confirm = scanner.nextLine();
                if (confirm.equals("Y")) {
                    students.remove(student);
                }
                break;
            }
        }
        if (!flag){
            System.err.println("Not found student with this id!");
        }
    }

    public void sortAvgUp(){
        ComparatorUp comparatorUp = new ComparatorUp();
        students.sort(comparatorUp);
        display();
    }

    public void sortAvgDown(){
        ComparatorDown comparatorDown = new ComparatorDown();
        students.sort(comparatorDown);
        display();
    }

    public void readFile(Scanner scanner){
        System.out.println("Reading the file will delete the old data, do you want to read the file(Y/N)?");
        String confirm = scanner.nextLine();
        if (confirm.equals("Y")) {
            BufferedReader br = null;
            try {
                String line;
                br = new BufferedReader(new FileReader("D:\\thiModule2\\src\\thiModule2\\students.csv"));
                while ((line = br.readLine()) != null) {
                    printStudent(parseCsvLine(line));
                }
            } catch (IOException e) {
                System.err.println("No data");
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeFile(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\thiModule2\\src\\thiModule2\\students.csv"));
            for (Student student: students){
                bw.write(student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getGender() + ","
                + student.getAddress() + "," + student.getAverageGrade()+"\n");
            }
            bw.close();
        }catch (Exception e){
        e.printStackTrace();
    }
    }

    public List<String> parseCsvLine(String csvLine){
        List<String> result = new ArrayList<>();
        if (csvLine != null){
            String[] splitData = csvLine.split(",");
            result.addAll(Arrays.asList(splitData));
        }
        return result;
    }

    public void printStudent(List<String> students){
        System.out.println("Student{id = " + students.get(0) + ", name = " + students.get(1) +
                ", age = " + students.get(2)  +  ", gender = " + students.get(3) + ", address = " + students.get(4)
                + ", averageGrade = " + students.get(5) + "}");
    }
}

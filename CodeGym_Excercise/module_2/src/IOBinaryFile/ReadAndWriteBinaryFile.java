package IOBinaryFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteBinaryFile {
    public static void writeToFile(String path, List<Student> students){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)));
            oos.writeObject(students);
            oos.close();
        }catch (IOException e){
             e.printStackTrace();
        }
    }

    public static List<Student> readFromDataFile(String path){
        List<Student> students = new ArrayList<>();
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            students = (List<Student>) ois.readObject();
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "thanh", "HaDong"));
        students.add(new Student(2, "lam", "NamTuLiem"));
        students.add(new Student(3, "nam", "DongDa"));
        writeToFile("D:\\module2\\text\\listStudent.txt", students);
        List<Student> studentDataFromFile = readFromDataFile("D:\\module2\\text\\listStudent.txt");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }
}

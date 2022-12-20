package Minitest.minitest2.Employee;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    private final ArrayList<Employee> employees;

    public EmployeeManager() {
        employees = readFile("D:\\module2\\text\\employees.txt");
    }

    public void add(int choice, Scanner scanner){
        System.out.println("Enter employee code: ");
        String employeeCode = scanner.nextLine();
        System.out.println("Enter employee name: ");
        String employeeName = scanner.nextLine();
        System.out.println("Enter age:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter phone number:");
        int phoneNo = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        if(choice == 1){
            System.out.println("Enter salary");
            int salary = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter fine");
            int fine = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter bonus");
            int bonus = Integer.parseInt(scanner.nextLine());
            Employee employee = new EmployeeFullTime(employeeCode, employeeName, age, phoneNo, email, bonus, fine, salary);
            employees.add(employee);
        }
        if(choice == 2){
            System.out.println("Enter working hour");
            int workingHour = Integer.parseInt(scanner.nextLine());
            Employee employee = new EmployeePartTime(employeeCode, employeeName, age, phoneNo, email, workingHour);
            employees.add(employee);
        }
        writeToFile("D:\\module2\\text\\employees.txt", employees);
    }

    public void display(){
        if (employees.isEmpty()){
            System.out.println("No available employee ");
        }
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public int averageSalary(){
        int SumSalary = 0;
        for (Employee employee: employees){
            if (employee instanceof EmployeeFullTime){
                SumSalary += ((EmployeeFullTime) employee).totalIncome();
            }
            if (employee instanceof EmployeePartTime){
                SumSalary += ((EmployeePartTime) employee).totalIncome();
            }
        }
        return SumSalary / employees.size();
    }

    public void filterSalaryLessThanAverage(){
        for (Employee employee: employees){
            if (employee instanceof EmployeeFullTime){
               if(((EmployeeFullTime) employee).totalIncome() < averageSalary()){
                   System.out.println(employee);
               }
            }

            if (employee instanceof EmployeePartTime){
                if(((EmployeePartTime) employee).totalIncome() < averageSalary()){
                    System.out.println(employee);
                }
            }
        }
    }

    public long sumPartTimeEmployeeSalary(){
        long sum = 0;
        for (Employee employee: employees){
            if (employee instanceof EmployeePartTime){
                sum += ((EmployeePartTime) employee).totalIncome();
            }
        }
        return sum;
    }

    public void sortFullTimeEmployeeSalaryUp(){
            AgeComparator ageComparator = new AgeComparator();
            employees.sort(ageComparator);
        for (Employee employee: employees){
            if (employee instanceof EmployeeFullTime){
                System.out.println(employee);
            }
        }
    }

    private ArrayList<Employee> readFile(String path){
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(path)));
            employees = (ArrayList<Employee>) ois.readObject();
            ois.close();
        }catch (Exception e){
            System.out.println();
        }
        return employees;
    }

    public void writeToFile(String path, ArrayList<Employee> employees){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)));
            oos.writeObject(employees);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package Minitest.minitest2.Employee;

import java.util.Scanner;

public class EmployeeSystem {
    private final EmployeeManager employeeManager;
    private final Scanner scanner;

    public EmployeeSystem() {
        this.employeeManager = new EmployeeManager();
        this.scanner = new Scanner(System.in);
    }

    public void menuEmployeeManager() {
            int choice = -1;
            while (choice != 0) {
                try {
                    System.out.println("Menu");
                    System.out.println("1. Add employee");
                    System.out.println("2. Average salary");
                    System.out.println("3. List employee has less than average salary");
                    System.out.println("4. Sum part-time employee salary");
                    System.out.println("5. Sort full-time employee salary up");
                    System.out.println("6. Display");
                    System.out.println("0. Exit");
                    System.out.println("Enter your choice: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            menuAddEmployee();
                            break;
                        case 2:
                            System.out.println("Average salary of all employee");
                            System.out.println(employeeManager.averageSalary());
                            break;
                        case 3:
                            employeeManager.filterSalaryLessThanAverage();
                            break;
                        case 4:
                            System.out.println("Sum of part-time employee salary: ");
                            System.out.println(employeeManager.sumPartTimeEmployeeSalary());
                            break;
                        case 5:
                            employeeManager.sortFullTimeEmployeeSalaryUp();
                            break;
                        case 6:
                            employeeManager.display();
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Please enter your choice");
                }
            }
    }

    public void menuAddEmployee() {
        int choice1 = -1;
        while (choice1 != 0) {
            System.out.println("Menu");
            System.out.println("1. Add full-time employee");
            System.out.println("2. Add part-time employee");
            System.out.println("0. Back");
            System.out.println("Enter your choice: ");
            choice1 = Integer.parseInt(scanner.nextLine());
            if (choice1 != 0) {
                employeeManager.add(choice1, scanner);
            }
        }
    }
}
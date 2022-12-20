package Minitest.minitest2.Employee;


import java.io.Serializable;

public class Employee implements Serializable {
    private String employeeCode = "123456";
    private String name = "Thanh";
    private int age = 23;
    private int phoneNo = 9999;
    private String email = "thanhemail@gmail.com";

    public Employee() {
    }

    public Employee(String employeeCode, String name, int age, int phoneNo, String email) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
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

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "Employee{" +
                "EmployeeCode = " + employeeCode + ", Name = " + name + ", Age = " + age +
                ", PhoneNo = " + phoneNo + ", Email = " + email;
    }
}




package com.example.thimodule3.Model;

public class Employee {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private double salary;
    private Department department;

    public Employee(String name, String email, String address, String phone, double salary, Department department) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
        this.department = department;
    }

    public Employee(Long id, String name, String email, String address, String phone, double salary, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

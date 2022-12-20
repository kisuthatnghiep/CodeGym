package com.example.casestudy3.model;

public class Singer {
    private long id;
    private String name;
    private String account;
    private String password;
    private String phone;
    private String email;
    private double income;
    private int status;

    public Singer() {
    }

    public Singer(long id, String name, String account, String password, String phone, String email, double income, int status) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.income = income;
        this.status = status;
    }

    public Singer(String name, String account, String password, String phone, String email, double income, int status) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.income = income;
        this.status = status;
    }
    public Singer(String name){
        this.name = name;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

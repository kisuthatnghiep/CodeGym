package com.example.casestudy3.model;

public class User {
    private long id;
    private String name;
    private String account;
    private String password;
    private String phone;
    private String email;
    private double wallet;
    private int status;

    public User() {
    }

    public User(long id, String name, String account, String password, String phone, String email, double wallet, int status) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.wallet = wallet;
        this.status = status;
    }

    public User(String name, String account, String password, String phone, String email, double wallet, int status) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.wallet = wallet;
        this.status = status;
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

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

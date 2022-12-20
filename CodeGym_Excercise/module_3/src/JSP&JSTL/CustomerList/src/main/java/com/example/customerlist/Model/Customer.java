package com.example.customerlist.Model;

public class Customer {
    private String name;
    private String birth;
    private String address;
    private String sourceImg;

    public Customer() {
    }

    public Customer(String name, String birth, String address, String sourceImg) {
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.sourceImg = sourceImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSourceImg() {
        return sourceImg;
    }

    public void setSourceImg(String sourceImg) {
        this.sourceImg = sourceImg;
    }


}

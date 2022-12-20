package com.example.casestudy3.model;

public class Song {
    private long id;
    private String name;
    private String link;
    private String description;
    private double price;
    private long singerId;
    private int status;

    public Song() {
    }

    public Song(long id, String name, String link, String description, double price, long singerId, int status) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.description = description;
        this.price = price;
        this.singerId = singerId;
        this.status = status;
    }

    public Song(String name, String link, String description, double price, long singerId, int status) {
        this.name = name;
        this.link = link;
        this.description = description;
        this.price = price;
        this.singerId = singerId;
        this.status = status;
    }

    public Song(long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Song(long id, String name, String link, String description, double price) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.description = description;
        this.price = price;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getSingerId() {
        return singerId;
    }

    public void setSingerId(long singerId) {
        this.singerId = singerId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

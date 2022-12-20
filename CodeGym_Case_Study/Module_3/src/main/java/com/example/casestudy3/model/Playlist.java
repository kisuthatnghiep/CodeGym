package com.example.casestudy3.model;

import java.time.LocalDate;
import java.sql.Date;

public class Playlist {
    private long id;
    private String name;
    private Date date;
    private long userId;

    public Playlist() {
    }

    public Playlist(long id, String name, Date date, long userId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.userId = userId;
    }


    public Playlist(long id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Playlist(String name, Date date, long userId) {
        this.name = name;
        this.date = date;
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}

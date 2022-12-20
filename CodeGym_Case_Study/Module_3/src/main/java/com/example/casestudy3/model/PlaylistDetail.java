package com.example.casestudy3.model;

import java.sql.Date;

public class PlaylistDetail {
    private long playListId;
    private long songId;
    private Date date;
    private int status;

    public PlaylistDetail() {
    }

    public PlaylistDetail(long playListId, long songId, Date date, int status) {
        this.playListId = playListId;
        this.songId = songId;
        this.date = date;
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getPlayListId() {
        return playListId;
    }

    public void setPlayListId(long playListId) {
        this.playListId = playListId;
    }

    public long getSongId() {
        return songId;
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }
}

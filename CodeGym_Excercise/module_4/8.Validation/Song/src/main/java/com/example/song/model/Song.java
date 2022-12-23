package com.example.song.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String singer;
    private LocalDate localDate;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String sound;
    @Transient
    private MultipartFile soundFile;


    public Song() {
    }

    public Song(Long id, String name, String singer, LocalDate localDate, Category category, String sound, MultipartFile soundFile) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.localDate = localDate;
        this.category = category;
        this.sound = sound;
        this.soundFile = soundFile;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public MultipartFile getSoundFile() {
        return soundFile;
    }

    public void setSoundFile(MultipartFile soundFile) {
        this.soundFile = soundFile;
    }
}

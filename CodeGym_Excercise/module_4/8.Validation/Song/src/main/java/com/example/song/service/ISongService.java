package com.example.song.service;

import com.example.song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService extends IGeneralService<Song> {
    Page<Song> findAll(Pageable pageable);
    Page<Song> findSongByNameContaining(String name, Pageable pageable);
}

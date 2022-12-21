package com.example.song.repository;

import com.example.song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends PagingAndSortingRepository<Song, Long> {
    Page<Song> findSongByNameContaining(String name, Pageable pageable);
}

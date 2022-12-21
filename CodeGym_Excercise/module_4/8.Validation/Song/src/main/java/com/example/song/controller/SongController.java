package com.example.song.controller;

import com.example.song.model.Song;
import com.example.song.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping
    public String index(@PageableDefault(value = 3) Pageable pageable, Model model, Optional<String> search) {
        if (search.isPresent()) {
            model.addAttribute("songs", songService.findSongByNameContaining(search.get(), pageable));
        } else {
            model.addAttribute("songs", songService.findAll());
        }
        return "/songList";
    }

    @GetMapping("/create")
    public String openSaveForm(Model model) {
        model.addAttribute("song", new Song());
        return "/categorySave";
    }

    @GetMapping("/save/{id}")
    public String openEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/categorySave";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Song song) {
        songService.save(song);
        return "redirect:/song";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        songService.deleteById(id);
        return "redirect:/song";
    }
}

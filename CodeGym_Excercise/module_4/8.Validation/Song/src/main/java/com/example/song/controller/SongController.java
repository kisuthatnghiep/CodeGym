package com.example.song.controller;

import com.example.song.model.Song;
import com.example.song.service.CategoryService;
import com.example.song.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;
    @Autowired
    private CategoryService categoryService;
    @Value("${upload}")
    private String upload;

    @GetMapping
    public String index(@PageableDefault(value = 3) Pageable pageable, Model model, @RequestParam Optional<String> search) {
        if (search.isPresent()) {
            model.addAttribute("songs", songService.findSongByNameContaining(search.get(), pageable));
            model.addAttribute("search", search.get());
        } else {
            model.addAttribute("songs", songService.findAll(pageable));
        }
        return "/songList";
    }

    @GetMapping("/create")
    public String openSaveForm(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        Song song = new Song();
        song.setLocalDate(LocalDate.now());
        model.addAttribute("song", song);
        return "/songSave";
    }

    @GetMapping("/save/{id}")
    public String openEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("song", songService.findById(id).get());
        model.addAttribute("categories", categoryService.findAll());
        return "/songSave";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Song song, @RequestParam("category") Long id) {
        song.setCategory(categoryService.findById(id).get());
        MultipartFile file = song.getSoundFile();
        String soundFile = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(upload + soundFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        song.setSound(soundFile);
        songService.save(song);
        return "redirect:/song";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        songService.deleteById(id);
        return "redirect:/song";
    }
}

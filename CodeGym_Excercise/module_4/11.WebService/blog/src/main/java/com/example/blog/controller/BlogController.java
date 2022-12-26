package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<Iterable<Blog>> index(@PageableDefault(value = 3) Pageable pageable) {
        Page<Blog> blogs;
        blogs = blogService.findAll(pageable);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<List<Blog>> index(@RequestParam Optional<String> search, @PageableDefault(value = 3) Pageable pageable) {
        List<Blog> blogs;
        if (search.isPresent()) {
            blogs = blogService.findBlogByNameContains(search.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok().body(blogs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBLog(@PathVariable Long id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogOptional.get().getId());
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.NO_CONTENT);
    }
}

package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findBlogByNameContains(String name, Pageable pageable);
    List<Blog> findBlogByNameContains(String name);
}

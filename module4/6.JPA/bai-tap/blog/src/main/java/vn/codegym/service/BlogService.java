package vn.codegym.service;

import vn.codegym.model.Blog;

import java.util.List;

public interface BlogService {
    void save(Blog blog);

    List<Blog> findAll();

    Blog findById(Long id);

    void update(Blog blog);

    void remove(Blog blog);
}

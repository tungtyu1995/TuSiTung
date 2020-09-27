package vn.codegym.baitap2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.baitap2.model.Blog;


import java.util.List;

public interface BlogService {
    void save(Blog blog);

    List<Blog> findAll();

    Blog findById(Long id);

    void update(Blog blog);

    void remove(Long id);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
}

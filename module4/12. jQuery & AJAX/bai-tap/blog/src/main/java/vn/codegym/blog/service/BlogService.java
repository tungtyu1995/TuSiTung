package vn.codegym.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.model.Category;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAllByTitleContainingOrderByDateAsc(String title, Pageable pageable);

    Page<Blog> findAllByCategoryOrderByDateAsc(Category category, Pageable pageable);

    List<Blog> findAllByTitleContaining(String title);

    Page<Blog> findAll(Pageable pageable);
}
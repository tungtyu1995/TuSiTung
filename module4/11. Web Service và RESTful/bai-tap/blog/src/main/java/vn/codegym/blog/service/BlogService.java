package vn.codegym.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.model.Category;

import java.util.List;

public interface BlogService {
    void save(Blog blog);

    List<Blog> getAll();

    Page<Blog> findAll(Pageable pageable);

    public Blog findById(Long id);

    public void update(Long id, Blog blog);

    void remove(Blog blog);

    Page<Blog> findByTitleBlogContaining(String search, Pageable pageable);

    List<Blog> findAllByCategory(Category category);
}

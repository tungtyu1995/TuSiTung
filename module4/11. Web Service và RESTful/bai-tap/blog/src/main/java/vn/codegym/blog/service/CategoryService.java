package vn.codegym.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.blog.model.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);

    List<Category> getAll();

    Page<Category> findAll(Pageable pageable);

    public Category findById(Long id);

    public void update(Category category);

    void remove(Category category);
}

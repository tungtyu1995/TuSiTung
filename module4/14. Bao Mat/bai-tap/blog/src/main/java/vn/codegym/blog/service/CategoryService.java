package vn.codegym.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.blog.model.Category;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}
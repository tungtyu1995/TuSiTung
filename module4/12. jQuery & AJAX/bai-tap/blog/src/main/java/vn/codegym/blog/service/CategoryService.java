package vn.codegym.blog.service;

import vn.codegym.blog.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}

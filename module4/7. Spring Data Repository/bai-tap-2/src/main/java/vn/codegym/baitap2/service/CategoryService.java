package vn.codegym.baitap2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.baitap2.model.Blog;
import vn.codegym.baitap2.model.Category;

public interface CategoryService {

    Iterable<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);

    Page<Category> findAll(Pageable pageable);
}

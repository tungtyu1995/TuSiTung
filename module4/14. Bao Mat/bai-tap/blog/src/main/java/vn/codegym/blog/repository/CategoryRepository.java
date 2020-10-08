package vn.codegym.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.blog.model.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Page<Category> findAll(Pageable pageable);
}
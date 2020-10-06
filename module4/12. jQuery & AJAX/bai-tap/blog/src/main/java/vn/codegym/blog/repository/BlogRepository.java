package vn.codegym.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.model.Category;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAllByTitleContainingOrderByDateAsc(String title, Pageable pageable);

    Page<Blog> findAllByCategoryOrderByDateAsc(Category category, Pageable pageable);

    List<Blog> findAllByTitleContaining(String title);

    Page<Blog> findAll(Pageable pageable);
}

package vn.codegym.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.model.Category;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findByTitleBlogContaining(String search, Pageable pageable);

    List<Blog> findAllByCategory(Category category);
}

package vn.codegym.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.blog.model.Blog;

@Repository
public interface BlogRepository  extends JpaRepository<Blog, Long> {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByNameContaining(String name, Pageable pageable);

    Page<Blog> findAllByCategory_Name(String name, Pageable pageable);
}

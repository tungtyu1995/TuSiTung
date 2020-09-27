package vn.codegym.baitap2.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import vn.codegym.baitap2.model.Blog;

import java.util.List;


public interface BlogRepository extends JpaRepository<Blog, Long> {

    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
}

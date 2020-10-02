package vn.codegym.baitap2.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.baitap2.model.Blog;


public interface BlogRepository extends JpaRepository<Blog, Long> {



    Page<Blog> findBlogsByCategory_NameCategoryAndNameContaining(String cateName, String name, Pageable pageable);

    Page<Blog> findAllByNameContaining(String name, Pageable pageable);

    Page<Blog> findAllByTypeContaining(String type, Pageable pageable);

    Page<Blog> findAllByContentContaining(String content, Pageable pageable);

}

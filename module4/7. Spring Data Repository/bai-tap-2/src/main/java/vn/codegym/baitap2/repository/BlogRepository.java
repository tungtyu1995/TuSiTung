package vn.codegym.baitap2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.baitap2.model.Blog;


public interface BlogRepository extends JpaRepository<Blog, Long> {


}

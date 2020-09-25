package vn.codegym.repository;


import vn.codegym.model.Blog;


import java.util.List;

public interface BlogRepository {
    void save(Blog blog);

    List<Blog> findAll();

    Blog findById(Long id);

    void update(Blog blog);

    void remove(Blog blog);

}

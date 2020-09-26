package vn.codegym.bucanhcuangaynew.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.bucanhcuangaynew.model.Comment;


import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    void save(Comment comment);

    Comment findById(Long id);

    void update(Comment comment);

    void remove(Long id);

    Page<Comment> findAll(Pageable pageable);


}

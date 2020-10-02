package vn.codegym.library_manage.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.library_manage.model.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
    List<Comment> findAll();

    Comment findById(Long id);

    void save(Comment comment);

    Page<Comment> findAllByContentContaining(String content, Pageable pageable);

    Map<Integer,String> getList();

}

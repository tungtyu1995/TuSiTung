package vn.codegym.service;

import vn.codegym.model.Comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);

    List<Comment> findAll();

    Comment findById(Long id);

    void update(Comment comment);

    void remove(Comment comment);
}

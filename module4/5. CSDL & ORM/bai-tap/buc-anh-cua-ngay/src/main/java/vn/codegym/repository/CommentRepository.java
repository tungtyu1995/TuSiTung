package vn.codegym.repository;

import vn.codegym.model.Comment;

import java.util.List;

public interface CommentRepository {
    void save(Comment comment);

    List<Comment> findAll();

    Comment findById(Long id);

    void update(Comment comment);
}

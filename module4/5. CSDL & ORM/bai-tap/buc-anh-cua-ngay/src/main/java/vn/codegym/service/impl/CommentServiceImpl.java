package vn.codegym.service.impl;


import vn.codegym.model.Comment;
import vn.codegym.repository.CommentRepository;
import vn.codegym.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        Comment comment = commentRepository.findById(id);
        return comment;
    }

    @Override
    public void update(Comment comment) {
        commentRepository.update(comment);
    }
}

package vn.codegym.library_manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import vn.codegym.library_manage.model.Comment;
import vn.codegym.library_manage.repository.CommentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CommentServiceImpl implements CommentService {
    private static Map<Integer,String> listErrorCmt;
    static{
        listErrorCmt = new HashMap<>();
        listErrorCmt.put(1,"gai");
        listErrorCmt.put(2,"nu");
        listErrorCmt.put(3,"girl");
    }
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Page<Comment> findAllByContentContaining(String content, Pageable pageable) {
        return commentRepository.findAllByContentContaining(content,pageable);
    }

    public Map<Integer,String> getList(){
        return listErrorCmt;
    }
}

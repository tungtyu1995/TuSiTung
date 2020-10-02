package vn.codegym.library_manage.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.library_manage.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    Page<Comment> findAllByContentContaining(String content, Pageable pageable);

}

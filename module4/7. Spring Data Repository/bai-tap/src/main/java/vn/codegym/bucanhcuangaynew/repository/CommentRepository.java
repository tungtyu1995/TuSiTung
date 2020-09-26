package vn.codegym.bucanhcuangaynew.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.bucanhcuangaynew.model.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long> {

}

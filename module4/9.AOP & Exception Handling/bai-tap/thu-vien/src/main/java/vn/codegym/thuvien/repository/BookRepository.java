package vn.codegym.thuvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.thuvien.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}

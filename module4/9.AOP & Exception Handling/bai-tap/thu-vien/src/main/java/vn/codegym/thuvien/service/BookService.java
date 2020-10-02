package vn.codegym.thuvien.service;

import vn.codegym.thuvien.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();

    Book getById(int id);

    boolean rentBook(Book book);

    void giveBook(Book book);
}

package vn.codegym.thuvien.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.thuvien.model.Book;
import vn.codegym.thuvien.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public boolean rentBook(Book book) {
        Book tempBook = bookRepository.getOne(book.getId());
        if (tempBook.getAmount() == 0) {
            return false;
        } else {
            tempBook.setAmount(tempBook.getAmount() - 1);
            bookRepository.save(tempBook);
            return true;
        }
    }

    @Override
    public void giveBook(Book book) {
        Book tempBook = bookRepository.getOne(book.getId());
        tempBook.setAmount(tempBook.getAmount() + 1);
        bookRepository.save(tempBook);
    }
}

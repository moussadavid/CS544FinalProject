package edu.mum.cs544.services;

import java.util.List;

import edu.mum.cs544.entities.Book;
import edu.mum.cs544.repositories.IBookDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class BookService {
    private final IBookDao bookDao;

    public List<Book> getAll() {
        return bookDao.findAll();
    }

    public void add(Book book) {
        bookDao.save(book);
    }

    public Book get(int id) {
        return bookDao.findById(id).get();
    }

    public void update(Book book) {
        bookDao.save(book);
    }

    public void delete(int id) {
        bookDao.deleteById(id);
    }
}
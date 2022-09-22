package edu.mum.cs544.controllers;

import edu.mum.cs544.entities.Book;
import edu.mum.cs544.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> getAll() {
        System.out.println("GetALL");
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable int id) {
        System.out.println("Get One");
        return bookService.get(id);
    }

    @PostMapping
    public RedirectView add(@RequestBody Book book) {
        bookService.add(book);
        return new RedirectView("/book/" + book.getId());
    }

    @PutMapping
    public void update(@RequestBody Book book) {
        bookService.update(book);
    }

    @PostMapping("/{id}")
    public void delete(@PathVariable long id) {
        bookService.delete((int) id);
    }

}

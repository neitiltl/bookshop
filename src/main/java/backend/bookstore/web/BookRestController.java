package backend.bookstore.web;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;

@RestController
public class BookRestController {

    private final BookRepository repository;

    public BookRestController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping ("/books")
    public Iterable<Book> findAllBooks() {
        return repository.findAll();
    }

    @GetMapping ("/books/{id}")
    public Optional<Book> findById(@PathVariable("id") Long id) {
        return repository.findById(id);
    }


}

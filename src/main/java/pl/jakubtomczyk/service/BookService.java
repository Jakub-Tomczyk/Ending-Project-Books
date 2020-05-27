package pl.jakubtomczyk.service;


import org.springframework.stereotype.Service;
import pl.jakubtomczyk.entity.Book;
import pl.jakubtomczyk.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(Book book){this.bookRepository.save(book);}

    public List<Book> readAll(){return this.bookRepository.findAll();}

    public void delete(Book book){this.bookRepository.delete(book);}

    public void update(Book book, Long id){this.bookRepository.findOneById(id);}
}

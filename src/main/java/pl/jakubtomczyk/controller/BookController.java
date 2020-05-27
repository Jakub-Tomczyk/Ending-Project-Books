package pl.jakubtomczyk.controller;

import org.springframework.stereotype.Controller;
import pl.jakubtomczyk.service.BookService;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


}

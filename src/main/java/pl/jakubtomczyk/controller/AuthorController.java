package pl.jakubtomczyk.controller;


import org.springframework.stereotype.Controller;
import pl.jakubtomczyk.service.AuthorService;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
}

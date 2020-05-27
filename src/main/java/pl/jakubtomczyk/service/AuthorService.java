package pl.jakubtomczyk.service;


import org.springframework.stereotype.Service;
import pl.jakubtomczyk.entity.Author;
import pl.jakubtomczyk.repository.AuthorRepository;

import javax.swing.undo.AbstractUndoableEdit;
import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void save(Author author){this.authorRepository.save(author);}

    public List<Author> readAll(){return this.authorRepository.findAll();}

    public void delete(Author author){this.authorRepository.delete(author);}

    public void update(Author author, Long id){this.authorRepository.findOneById(id);}
}

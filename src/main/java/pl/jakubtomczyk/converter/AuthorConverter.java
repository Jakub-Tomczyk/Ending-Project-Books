package pl.jakubtomczyk.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.jakubtomczyk.entity.Author;
import pl.jakubtomczyk.repository.AuthorRepository;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public Author convert(String id) {
        return authorRepository.findOneById(Long.parseLong(id));
    }
}

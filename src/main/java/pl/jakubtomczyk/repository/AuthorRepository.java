package pl.jakubtomczyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jakubtomczyk.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    public Author findOneById(Long id);
}

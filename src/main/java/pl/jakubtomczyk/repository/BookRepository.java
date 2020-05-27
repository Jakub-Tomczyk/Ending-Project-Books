package pl.jakubtomczyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jakubtomczyk.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public Book findOneById(Long id);
}

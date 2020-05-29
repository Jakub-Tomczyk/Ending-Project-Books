package pl.jakubtomczyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.jakubtomczyk.entity.Book;
import pl.jakubtomczyk.entity.Publisher;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public Book findOneById(Long id);

    // Lista książek z danej kategorii posortowana po ratingu
    @Query("SELECT b FROM Book b ORDER BY b.rating DESC")
    List<Book> findAllByRatingASC();

    // Listę książek dla zadanego wydawcy.
    @Query("SELECT b FROM Book b WHERE b.publisher = :publisher")
    List<Book> findAllByPublisherUsingQuery(@Param("publisher") Publisher publisher);


}

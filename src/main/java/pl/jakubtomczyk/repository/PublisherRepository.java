package pl.jakubtomczyk.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jakubtomczyk.entity.Publisher;

@Repository
public interface PublisherRepository  extends JpaRepository<Publisher, Long> {
    public Publisher findOneById(Long id);
}

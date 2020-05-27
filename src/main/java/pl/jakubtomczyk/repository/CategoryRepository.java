package pl.jakubtomczyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jakubtomczyk.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findOneById(Long id);
}

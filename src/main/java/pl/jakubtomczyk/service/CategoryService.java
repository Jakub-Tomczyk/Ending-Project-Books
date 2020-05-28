package pl.jakubtomczyk.service;

import org.springframework.stereotype.Service;
import pl.jakubtomczyk.entity.Category;
import pl.jakubtomczyk.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void save(Category category) {this.categoryRepository.save(category); }

    public List<Category> readAll(){ return this.categoryRepository.findAll();}

    public void delete(Category category){this.categoryRepository.delete(category);}

    public void deleteById(Long id) {
        Category category = findById(id);
        this.categoryRepository.delete(category);
    }

    public void update(Category category, Long id){this.categoryRepository.findOneById(id);
    }
     public Category findById(Long id) {
            return this.categoryRepository.findById(id).orElse(null);
        }
}

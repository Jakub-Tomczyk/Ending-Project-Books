package pl.jakubtomczyk.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.jakubtomczyk.entity.Category;
import pl.jakubtomczyk.repository.CategoryRepository;
@Component
public class CategoryConverter implements Converter<String, Category> {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category convert(String id){
        return categoryRepository.findOneById(Long.parseLong(id));
    }
}

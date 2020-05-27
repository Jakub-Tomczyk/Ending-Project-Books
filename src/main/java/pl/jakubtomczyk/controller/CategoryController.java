package pl.jakubtomczyk.controller;

import org.springframework.stereotype.Controller;
import pl.jakubtomczyk.service.CategoryService;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}

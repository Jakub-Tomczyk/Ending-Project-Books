package pl.jakubtomczyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubtomczyk.entity.Category;
import pl.jakubtomczyk.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // odsyła do formularza z dodaniem kategorii
    @GetMapping("/formCategory")
    public String getForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/categoryForm";
    }

    // wraca z formularza. Zapisuje do bazy danych nową kategorię. A do tego wraca do strony "home"
    @PostMapping("formCategory")
    public String post(@Valid @ModelAttribute Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category/categoryForm";
        }
        try {
            this.categoryService.save(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/categoryList";
    }

    //możliwość wyświetlania wszystkich kategorii w liście kategorii w pliku .jsp
    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.readAll();
    }

    // zwraca listę wszystkich kategorii. Najpierw przekieruje do pliku categoryList.jsp a tam je poprzez pętle wyświetli
    @GetMapping("categoryList")
    public String getList(Model model){
        model.addAttribute("categories", categoryService.readAll());
        return "category/categoryList";
    }

    //edytowanie kategorii
    @GetMapping("/formCategory/{id}")
    public String get(Model model, @PathVariable long id){
        model.addAttribute("category", categoryService.findById(id));
        return "category/categoryForm";
    }

    //usuwanie kategori
    @GetMapping("/deleteCategory/{id}")
    public String delete(@PathVariable long id){
        categoryService.deleteById(id);
        return "redirect:/categoryList";
    }
}

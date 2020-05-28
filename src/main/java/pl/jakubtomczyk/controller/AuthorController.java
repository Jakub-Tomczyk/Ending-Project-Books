package pl.jakubtomczyk.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubtomczyk.entity.Author;
import pl.jakubtomczyk.service.AuthorService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // odsyła do formularza z dodaniem autora
    @GetMapping("/formAuthor")
    public String getForm(Model model) {
        model.addAttribute("author", new Author());
        return "author/authorForm";
    }

    // wraca z formularza. Zapisuje do bazy danych nowego authora. A do tego wraca do strony "home"
    @PostMapping("formAuthor")
    public String post(@Valid @ModelAttribute Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "author/authorForm";
        }
        try {
            this.authorService.save(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/home";
    }

    //możliwość wyświetlania wszystkich autorów w liście ksiażęk w pliku .jsp
    @ModelAttribute("authors")
    public List<Author> authors(){return authorService.readAll();}

    // zwraca listę wszystkich autorów. Najpierw przekieruje do pliku authorList.jsp a tam je poprzez pętle wyświetli
    @GetMapping("authorList")
    public String getList(Model model){
        model.addAttribute("authors", authorService.readAll());
        return "author/authorList";
    }

    //edytowanie autora
    @GetMapping("/formAuthor/{id}")
    public String get(Model model, @PathVariable long id){
        model.addAttribute("author", authorService.findById(id));
        return "author/authorForm";
    }

    //usuwanie autora
    @GetMapping("/deleteAuthor/{id}")
    public String delete(@PathVariable long id){
        authorService.deleteById(id);
        return "redirect:/home";
    }
}

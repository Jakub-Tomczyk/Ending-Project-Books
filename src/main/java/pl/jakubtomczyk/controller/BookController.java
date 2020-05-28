package pl.jakubtomczyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubtomczyk.entity.Author;
import pl.jakubtomczyk.entity.Book;
import pl.jakubtomczyk.entity.Category;
import pl.jakubtomczyk.entity.Publisher;
import pl.jakubtomczyk.enums.Rating;
import pl.jakubtomczyk.service.AuthorService;
import pl.jakubtomczyk.service.BookService;
import pl.jakubtomczyk.service.CategoryService;
import pl.jakubtomczyk.service.PublisherService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final PublisherService publisherService;




    public BookController(BookService bookService, CategoryService categoryService, AuthorService authorService, PublisherService publisherService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }


    // odsyła do formularza z dodawaniem książki
    @GetMapping("/formBook")
    public String getForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/bookForm";
    }

 // wraca z formularza, zapisuje do bazy danych oraz wyrzuca na na stronę Home.
    @PostMapping("/formBook")
    public String post(@Valid @ModelAttribute Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/bookForm";
        }
        try {
            this.bookService.save(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/home";
    }


    // możliwość wyświetlania wszystkich Ratingów
    @ModelAttribute("ratings")
    public List<Rating> ratings() {return Arrays.asList(Rating.values());}

    //możliwość wyświetlenia wszystkich Books
    @ModelAttribute("books")
    public List<Book> books() {
        return bookService.readAll();
    }

    // możliwość wyświetlenia wszystkich Kategorii w liście książek w pliku .jsp
    @ModelAttribute("categories")
    public List<Category> categories() {return categoryService.readAll();}

    //możliwość wyświetlania wszystkich autorów w liście ksiażęk w pliku .jsp
    @ModelAttribute("authors")
    public List<Author> authors(){return authorService.readAll();}

    //Możliwość wyświetlania wszystkich wydawców w liście ksiażek w pliku .jsp
    @ModelAttribute("publishers")
    public List<Publisher> publishers(){return publisherService.readAll();}

    // zwraca listę wszystkich książek. Najpierw przekieruje do pliku book  List.jsp a tam je poprzez pętle wyświetli
    @GetMapping("/bookList")
    public String getList(Model model) {
        model.addAttribute("books", bookService.readAll());
        return "book/bookList";
    }

    //edytowanie usera
    @GetMapping("/formBook/{id}")
    public String get(Model model, @PathVariable long id) {
        model.addAttribute("book", bookService.findById(id));
        return "book/bookForm";
    }

    //usuwanie usera
    @GetMapping("/deleteBook/{id}")
    public String delete(@PathVariable long id) {
        bookService.deleteById(id);
        return "redirect:/home";
    }


}

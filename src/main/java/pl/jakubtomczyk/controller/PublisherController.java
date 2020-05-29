package pl.jakubtomczyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubtomczyk.entity.Publisher;
import pl.jakubtomczyk.service.PublisherService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    // odsyła do formularza z dodaniem wydawcy
    @GetMapping("/formPublisher")
    public String getForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher/publisherForm";
    }

    // wraca z formularza. Zapisuje do bazy danych nowego wydawcę. A do tego wraca do strony "home"
    @PostMapping("formPublisher")
    public String post(@Valid @ModelAttribute Publisher publisher, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "publisher/publisherForm";
        }
        try {
            this.publisherService.save(publisher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/home";
    }

    //możliwość wyświetlania wszystkich wydawców w liście wydawców w pliku .jsp
    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherService.readAll();
    }

    // zwraca listę wszystkich wydawców. Najpierw przekieruje do pliku publisherList.jsp a tam je poprzez pętle wyświetli
    @GetMapping("publisherList")
    public String getList(Model model){
        model.addAttribute("publishers", publisherService.readAll());
        return "publisher/publisherList";
    }

    //edytowanie wydawcu
    @GetMapping("/formPublisher/{id}")
    public String get(Model model, @PathVariable long id){
        model.addAttribute("publisher", publisherService.findById(id));
        return "publisher/publisherForm";
    }

    //usuwanie wydawcy
    @GetMapping("/deletePublisher/{id}")
    public String delete(@PathVariable long id){
        publisherService.deleteById(id);
        return "redirect:/home";
    }
}

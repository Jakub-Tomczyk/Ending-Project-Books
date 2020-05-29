package pl.jakubtomczyk.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.jakubtomczyk.entity.User;
import pl.jakubtomczyk.fixture.InitDataFixture;
import pl.jakubtomczyk.service.UserService;
import pl.jakubtomczyk.validation.group.UserValidationGroup;

import javax.validation.Valid;
import java.util.List;


@Controller
public class UserController {

    private final UserService userService;
    private final InitDataFixture initDataFixture;


    public UserController(UserService userService, InitDataFixture initDataFixture) {
        this.userService = userService;
        this.initDataFixture = initDataFixture;
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(
            @AuthenticationPrincipal UserDetails customUser
    ) {
        return "You are logged as " + customUser;
    }

    @GetMapping("/about")
    public String about() {
        return "user/panel";
    }

    @GetMapping("/initData")
    @ResponseBody
    public String createUser() {

        this.initDataFixture.initRoles();
        this.initDataFixture.initUsers();
        return "initialized";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    // odsyła do formularza z dodawaniem użytkownika
    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "user/userForm";
    }

    // wraca z formularza, zapisuje do bazy danych oraz wyrzuca na na stronę Home.
    @PostMapping("/form")
    public String post(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/userForm";
        }
        try {
            this.userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/home";
    }

    //metoda do edytowania użytkownika razem z hasłem. Do tego muszę dodać w UserService nową metodę Update.
    // muszę też dodać grupy validacyjne.
    @PostMapping("/formEdit")
    public String update(@Validated(UserValidationGroup.class) @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/userFormEdit";
        }
        try {
            this.userService.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/home";
    }
    //odsyła do formularza do edycji
    @GetMapping("/formEdit/{id}")
    public String getEdit(Model model, @PathVariable long id) {
        model.addAttribute("user", userService.findById(id));
        return "user/userFormEdit";
    }

    //możliwość wyświetlenia wszystkich Userów
    @ModelAttribute("users")
    public List<User> users() {
        return userService.readAll();
    }

    // zwraca listę wszystkich użytkowników. Najpierw przekieruje do pliku userList.jsp a tam je poprzez pętle wyświetli
    @GetMapping("/usersList")
    public String getList(Model model) {
        model.addAttribute("users", userService.readAll());
        return "user/userList";
    }

    //edytowanie usera
    @GetMapping("/form/{id}")
    public String get(Model model, @PathVariable long id) {
        model.addAttribute("user", userService.findById(id));
        return "user/userForm";
    }

    //usuwanie usera
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        userService.deleteById(id);
        return "redirect:/home";
    }


}

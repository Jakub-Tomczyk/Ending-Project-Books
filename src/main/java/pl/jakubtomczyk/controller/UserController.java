package pl.jakubtomczyk.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubtomczyk.entity.User;
import pl.jakubtomczyk.service.UserService;


@Controller
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/form")
    public String getForm(Model model){
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/form")
    public String post(@ModelAttribute User user){
        try{
            this.userService.save(user);
        } catch (Exception e ) {
            e.printStackTrace();
        }return "redirect:/home";
    }


}

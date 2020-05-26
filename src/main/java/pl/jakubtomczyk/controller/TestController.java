package pl.jakubtomczyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class TestController {


    @RequestMapping("/")
    @ResponseBody
    public String home(){
        return "Testujemy czy działa";
    }


    @GetMapping("/test")
    public String test(){
        return "home";
    }
}

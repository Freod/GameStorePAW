package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.umg.paw.gamestorepaw.model.User;
import pl.umg.paw.gamestorepaw.service.UserService;

@Controller
public class RegisterController {
    @Autowired
    private UserService service;

    @GetMapping(value = "/register")
    public String showRegister() {
        return "/register";
    }

    @PostMapping(value = "/register")
    public void getRegister(User user){
        user.setActive(true);
        user.setRole("USER");
        service.save(user);
    }
}

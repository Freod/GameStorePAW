package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.umg.paw.gamestorepaw.model.Platform;
import pl.umg.paw.gamestorepaw.model.User;
import pl.umg.paw.gamestorepaw.service.UserService;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

@Controller
public class RegisterController {
    @Autowired
    private UserService service;

    @GetMapping(value = "/register")
    public String showRegister() {
        return "/register";
    }

    @PostMapping(value = "/register")
    public String getRegister(User user, Model model) throws NoSuchAlgorithmException {
        if (user.getName().isEmpty() || user.getName().length() > 255 || user.getSurname().isEmpty() || user.getSurname().length() > 255 || user.getEmail().isEmpty() || user.getEmail().length() > 255 || user.getPassword().isEmpty() || user.getPassword().length() > 40) {
            model.addAttribute("user", user);
            if (user.getName().isEmpty())
                model.addAttribute("alert", "First name can't be empty");
            else if (user.getName().length() > 255)
                model.addAttribute("alert", "First name length can't more than 255");
            else if (user.getSurname().isEmpty())
                model.addAttribute("alert", "Last name can't be empty");
            else if (user.getSurname().length() > 255)
                model.addAttribute("alert", "Last name length can't more than 255");
            else if (user.getEmail().isEmpty())
                model.addAttribute("alert", "Email can't be empty");
            else if (user.getEmail().length() > 255)
                model.addAttribute("alert", "Email length can't more than 255");
            else if (user.getPassword().length() > 40)
                model.addAttribute("alert", "Password length can't more than 40");
            else
                model.addAttribute("alert", "Password can't be empty");
            return "/register";
        }
        if (service.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("user", user);
            user.setEmail("");
            model.addAttribute("alert", "Email is used");
            return "/register";
        }
        if (user.getId() != null) {
            user.setId(null);
        }
        user.setActive(true);
        user.setRole("USER");
        service.save(user);
        return "index";
    }
}

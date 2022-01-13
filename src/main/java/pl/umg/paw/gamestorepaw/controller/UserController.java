package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.umg.paw.gamestorepaw.model.User;
import pl.umg.paw.gamestorepaw.repository.UserRepository;
import pl.umg.paw.gamestorepaw.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/list")
    public String getAllUsers(Model model) {
        model.addAttribute("users", service.findAll());
        return "/users/list";
    }

    @GetMapping("/edit/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        System.out.println(service.findById(id));
        model.addAttribute("user", service.findById(id));
        return "/users/edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, User user) {
        service.save(user);
        return "redirect:/users/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
        }
        return "redirect:/users/list";
    }
}

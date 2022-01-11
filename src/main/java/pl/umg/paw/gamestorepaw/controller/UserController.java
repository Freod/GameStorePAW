package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.umg.paw.gamestorepaw.model.User;
import pl.umg.paw.gamestorepaw.repository.UserRepository;
import pl.umg.paw.gamestorepaw.service.impl.UserServiceImpl;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl service;

    @Autowired
    private UserRepository repository;

    @GetMapping("/list")
    public String getAllUsers(Model model) {
        model.addAttribute("users", repository.findAll());
        return "/users/list";
    }

    @GetMapping("/edit/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        Optional<User> user = service.getById(id);
        model.addAttribute("user", repository.findAll());
        return "/users/edit";
    }

    @PostMapping("/edit/{id}")
    public void editUser(@PathVariable Long id, User user) {
        System.out.println(id);
        System.out.println(user);
//        return service.update(user);
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (service.getById(id).isPresent()) {
            service.deleteById(id);
        }
        return "redirect:/users/list";
    }
}

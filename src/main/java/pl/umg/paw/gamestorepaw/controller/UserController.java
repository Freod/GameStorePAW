package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.umg.paw.gamestorepaw.model.User;
import pl.umg.paw.gamestorepaw.repository.UserRepository;
import pl.umg.paw.gamestorepaw.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl service;

    @Autowired
    private UserRepository repository;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        model.addAttribute("users", repository.findAll());
        return "/users/list";
    }

    @PutMapping(value = "/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        //TODO:exceptions
        return service.update(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        if (service.getById(id).isPresent()) {
            service.deleteById(id);
        }
    }
}

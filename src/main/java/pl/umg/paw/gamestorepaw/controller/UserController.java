package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.umg.paw.gamestorepaw.model.User;
import pl.umg.paw.gamestorepaw.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl service;

    @GetMapping(value = "/list")
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @PostMapping(value = "/add")
    public User saveUser(@RequestBody User user) {
        //TODO:exceptions
        return service.save(user);
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

package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.umg.paw.gamestorepaw.model.User;
import pl.umg.paw.gamestorepaw.service.UserService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class RegisterController {
    @Autowired
    private UserService service;

    @GetMapping(value = "/register")
    public String showRegister() {
        return "/register";
    }

    @PostMapping(value = "/register")
    public void getRegister(User user) throws NoSuchAlgorithmException {
        user.setActive(true);
        user.setRole("USER");
        String password = hash(user.getPassword());
        user.setPassword(password);
        service.save(user);
    }

    public String hash(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}

package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.umg.paw.gamestorepaw.model.Game;
import pl.umg.paw.gamestorepaw.service.GameService;

@Controller
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService service;

    @GetMapping("/list")
    public String getAllGames(Model model) {
        model.addAttribute("games", service.findAll());
        return "/games/list";
    }

    @GetMapping("/add")
    public String getSaveGameForm() {
        return "/games/add";
    }

    @PostMapping("/add")
    public String saveGame(Game game) {
        service.save(game);
        return "redirect:/games/list";
    }

    @GetMapping("/update/{id}")
    public String getUpdateGameForm(@PathVariable Long id) {
        service.findById(id);
        return "/games/add";
    }

    @PostMapping("/update")
    public void updateGame(Game game) {
        //TODO:exceptions
        System.out.println(game);
//        service.update(game);
    }

    @GetMapping("/delete/{id}")
    public void deleteGame(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            System.out.println("delete by " + id);
//            service.deleteById(id);
        }
    }

    @PostMapping("/addToCart/{id}")
    public void addGameToCart(@PathVariable Long id){
        System.out.println(id);
        System.out.println(service.findById(id));
    }
}

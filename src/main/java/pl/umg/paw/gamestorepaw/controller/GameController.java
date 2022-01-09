package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.umg.paw.gamestorepaw.model.Game;
import pl.umg.paw.gamestorepaw.service.impl.GameServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameServiceImpl service;

    @GetMapping(value = "/list")
    public List<Game> getAllGames() {
        return service.findAll();
    }

    @PostMapping(value = "/add")
    public Game saveGame(@RequestBody Game game) {
        //TODO:exceptions
        return service.save(game);
    }

    @PutMapping(value = "/update/{id}")
    public Game updateGame(@PathVariable Long id, @RequestBody Game game) {
        //TODO:exceptions
        return service.update(game);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteGame(@PathVariable Long id) {
        if (service.getById(id).isPresent()) {
            service.deleteById(id);
        }
    }
}

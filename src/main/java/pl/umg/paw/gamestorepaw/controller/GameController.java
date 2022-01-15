package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.umg.paw.gamestorepaw.model.Game;
import pl.umg.paw.gamestorepaw.service.GameService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService service;

    @GetMapping("/list")
    public String getAllGames(Model model, HttpSession session) {
        List<Game> list = service.findAllNotSold();
        List<Game> cart = (ArrayList<Game>) session.getAttribute("cart");
        if(cart!=null){
            list.removeIf(game1->cart.stream()
                    .anyMatch(game2->game2.getId().equals(game1.getId())));
        }
        model.addAttribute("games", list);
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
        //TODO:UPDATE
        System.out.println(game);
//        service.update(game);
    }

    @GetMapping("/delete/{id}")
    public void deleteGame(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            System.out.println("delete by " + id);
            //TODO:DELETE
//            service.deleteById(id);
        }
    }

    @GetMapping("/sell")
    public String getSellGameForm(){
        System.out.println("asdasd");
        return "/games/sell";
    }

    @PostMapping("/sell")
    public void sellGame(Game game){
        System.out.println(game);
        //TODO:save
    }
}

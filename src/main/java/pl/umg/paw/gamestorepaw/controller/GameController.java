package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.util.EnumUtils;
import pl.umg.paw.gamestorepaw.model.Game;
import pl.umg.paw.gamestorepaw.model.Platform;
import pl.umg.paw.gamestorepaw.service.GameService;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService service;

    @GetMapping("/list")
    public String getAllGames(Model model, HttpSession session) {
        List<Game> list = service.findAllNotSold();
        List<Game> list2 = service.findAll();
        System.out.println(list);
        System.out.println(list2);
        List<Game> cart = (ArrayList<Game>) session.getAttribute("cart");
        if(cart!=null){
            list.removeIf(game1->cart.stream()
                    .anyMatch(game2->game2.getId().equals(game1.getId())));
        }
        model.addAttribute("games", list);
        return "/games/list";
    }

    @GetMapping("/add")
    public String getSaveGameForm(Model model) {
        List<Platform> platforms = Arrays.asList(Platform.values());
        model.addAttribute("platforms", platforms);
        return "/games/add";
    }

    @PostMapping("/add")
    public String saveGame(Game game, @RequestParam("image") MultipartFile multipartFile) {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        game.setImage(fileName);
        service.save(game);
        String uploadDir = "gamesImages/" + game.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
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
        return "/games/sell";
    }

    @PostMapping("/sell")
    public void sellGame(Game game){
        System.out.println(game);
        //TODO:save
    }
}

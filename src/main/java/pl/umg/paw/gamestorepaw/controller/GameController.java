package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.umg.paw.gamestorepaw.model.Game;
import pl.umg.paw.gamestorepaw.model.Platform;
import pl.umg.paw.gamestorepaw.service.GameService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService service;

    @PostConstruct
    public void createStartupModels() {
        service.save(new Game(1L, "Spider-man Miles Morales", Platform.PLAYSTATION5.toString(), 30, "Marvels-Spider-Man-Miles-Morales-Gra-PS5-1.jpg"));
        service.save(new Game(2L, "Returnal", Platform.PLAYSTATION5.toString(), 20, "i-returnal-gra-ps5.jpg"));
        service.save(new Game(3L, "Halo Infinite", Platform.XBOXSERIESX.toString(), 90, "microsoft-gra-xbox-one-halo-infinite,68782888225_8.jpg"));
    }

    @GetMapping("/list")
    public String getAllGames(Model model, HttpSession session) {
        List<Game> list = service.findAllNotSold();
        List<Game> list2 = service.findAll();
        System.out.println(list);
        System.out.println(list2);
        List<Game> cart = (ArrayList<Game>) session.getAttribute("cart");
        if (cart != null) {
            list.removeIf(game1 -> cart.stream()
                    .anyMatch(game2 -> game2.getId().equals(game1.getId())));
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
    public String saveGame(@RequestParam MultipartFile file, Game game, Model model) {
        if (game.getName().isEmpty() || game.getPlatform().isEmpty() || game.getPrice() < 1 || game.getPrice() > 999999) {
            List<Platform> platforms = Arrays.asList(Platform.values());
            model.addAttribute("platforms", platforms);
            model.addAttribute("game", game);
            if (game.getName().isEmpty())
                model.addAttribute("alert", "Name can't be empty");
            else if (game.getPlatform().isEmpty())
                model.addAttribute("alert", "Platform can't be empty");
            else
                model.addAttribute("alert", "Price range is between 1 and 999999");
            return "/games/add";
        }
        if (game.getId() != null) {
            game.setId(null);
        }
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        game.setImage(fileName);
        game = service.saveAndFlush(game);
        Path currentRelativePath = Paths.get("");
        String currentPath = currentRelativePath.toAbsolutePath().toString();
        String uploadDir = currentPath + "/src/main/resources/public/images/" + game.getId() + "/" + game.getImage();
        File dirPath = new File(uploadDir);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
        try {
            file.transferTo(new File(uploadDir));
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return "redirect:/games/list";
    }

//    @GetMapping("/update/{id}")
//    public String getUpdateGameForm(@PathVariable Long id) {
//        service.findById(id);
//        return "/games/add";
//    }

//    @PostMapping("/update")
//    public void updateGame(Game game) {
//        //TODO:UPDATE
//        System.out.println(game);
////        service.update(game);
//    }

//    @GetMapping("/delete/{id}")
//    public void deleteGame(@PathVariable Long id) {
//        if (service.findById(id).isPresent()) {
//            System.out.println("delete by " + id);
//            //TODO:DELETE
////            service.deleteById(id);
//        }
//    }

//    //TODO:SELL
//    @GetMapping("/sell")
//    public String getSellGameForm(){
//        return "/games/sell";
//    }

//    @PostMapping("/sell")
//    public void sellGame(Game game){
//        System.out.println(game);
//    }
}

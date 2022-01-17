package pl.umg.paw.gamestorepaw.controller;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.umg.paw.gamestorepaw.model.Game;
import pl.umg.paw.gamestorepaw.model.MyUserDetails;
import pl.umg.paw.gamestorepaw.model.Order;
import pl.umg.paw.gamestorepaw.model.User;
import pl.umg.paw.gamestorepaw.service.GameService;
import pl.umg.paw.gamestorepaw.service.OrderService;
import pl.umg.paw.gamestorepaw.service.RepairService;
import pl.umg.paw.gamestorepaw.service.UserService;

import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private GameService gameService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RepairService repairService;

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
        user.setPassword(service.findById(user.getId()).get().getPassword());
        if (user.getRole() == null)
            user.setRole("USER");
        else
            user.setRole(user.getRole() + ",USER");
        System.out.println(user);
        service.update(user);
        return "redirect:/users/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
        }
        return "redirect:/users/list";
    }

    @GetMapping("/reset/{id}")
    public String getResetPasswordForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.findById(id));
        return "/users/reset";
    }

    @PostMapping("/reset/{id}")
    public void resetPassword(@PathVariable Long id, String password) {
        User user = service.findById(id).get();
        user.setPassword(password);
        try {
            user.setPassword(hash(user.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            service.save(user);
        }
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

    @GetMapping("/account")
    public String getUserAccount(Model model) {
        String email = checkEmailLoggedUser();
        model.addAttribute("user", service.findByEmail(email).get());
        List<Order> order = orderService.findAllByUser(service.findByEmail(email).get());
        model.addAttribute("orders", order);
        model.addAttribute("repairs", repairService.findAllByUser(service.findByEmail(email).get()));
        return "/users/account";
    }

    @GetMapping("/cart")
    public String getUserCart(Model model, HttpSession session) {
        model.addAttribute("cart", (ArrayList<Game>) session.getAttribute("cart"));
        return "/users/cart";
    }

    @PostMapping("/cart")
    public String getPaymentCartForm(Model model, HttpSession session) {
        double price = 0;
        List<Game> cart = (ArrayList<Game>) session.getAttribute("cart");
        for (Game game : cart) {
            price += game.getPrice();
        }
        model.addAttribute("price", price);
        return "/users/payment";
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteFromUserCart(@PathVariable Long id, HttpSession session) {
        List<Game> cart = (ArrayList<Game>) session.getAttribute("cart");
        cart.removeIf(game1 -> cart.stream().anyMatch(game2 -> game1.getId().equals(gameService.findById(id).get().getId())));
        return "redirect:/users/cart";
    }

    @GetMapping("/cart/deleteAll")
    public String clearUserCart(HttpSession session) {
        session.setAttribute("cart", null);
        return "redirect:/users/cart";
    }

    @PostMapping("/payment")
    public String endUserCartPayment(Model model, HttpSession session) {
        List<Game> cart = (ArrayList<Game>) session.getAttribute("cart");
        User user = service.findByEmail(checkEmailLoggedUser()).get();
        Order order = new Order(user, cart);
        order.setStatus("Waiting");
        clearUserCart(session);
        orderService.save(order);
        return "redirect:/users/account";
    }

    @GetMapping("/addToCart/{id}")
    public String addGameToCart(@PathVariable Long id, HttpSession session) {
        Game game = gameService.findById(id).get();
        List<Game> cart = (ArrayList<Game>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        System.out.println(cart);
        cart.add(game);
        System.out.println(cart);
        session.setAttribute("cart", cart);
        return "redirect:../../games/list";
    }

    public String checkEmailLoggedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof MyUserDetails) {
            return ((MyUserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }
}

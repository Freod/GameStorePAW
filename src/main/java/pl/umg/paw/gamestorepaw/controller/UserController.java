package pl.umg.paw.gamestorepaw.controller;

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

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private GameService gameService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RepairService repairService;

    @PostConstruct
    public void createStartupModels() throws NoSuchAlgorithmException {
        User admin = new User(1L, "Admin", "Admin", "admin", "admin", "ADMIN,EMPLOYEE,USER", true);
        User employee = new User(2L, "Employee", "Employee", "employee", "employee", "EMPLOYEE,USER", true);
        User user = new User(3L, "User", "User", "user", "user", "USER", true);
        userService.save(admin);
        userService.save(employee);
        userService.save(user);
    }

    @GetMapping("/list")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/users/list";
    }

    @GetMapping("/edit/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "/users/edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, User user) {
        if(user.getId()==null){
            return "/users/list";
        }
        if(user.getName().isEmpty() || user.getSurname().isEmpty() || user.getEmail().isEmpty() || user.getRole().isEmpty()) {
            return "/user/edit/"+user.getId();
        }
        user.setHashedPassword(userService.findById(user.getId()).get().getPassword());
        if (user.getRole() == null)
            user.setRole("USER");
        else
            user.setRole(user.getRole() + ",USER");
        System.out.println(user);
        userService.update(user);
        return "redirect:/users/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (userService.findById(id).isPresent()) {
            userService.deleteById(id);
        }
        return "redirect:/users/list";
    }

    @GetMapping("/reset/{id}")
    public String getResetPasswordForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "/users/reset";
    }

    @PostMapping("/reset/{id}")
    public String resetPassword(@PathVariable Long id, String password){
        User user = userService.findById(id).get();
        if(password.isEmpty()){
            return "/users/reset/"+id;
        }
        try {
            user.setPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            userService.save(user);
            return "/users/list";
        }
    }

    @GetMapping("/account")
    public String getUserAccount(Model model) {
        String email = checkEmailLoggedUser();
        model.addAttribute("user", userService.findByEmail(email).get());
        List<Order> order = orderService.findAllByUser(userService.findByEmail(email).get());
        model.addAttribute("orders", order);
        model.addAttribute("repairs", repairService.findAllByUser(userService.findByEmail(email).get()));
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
        User user = userService.findByEmail(checkEmailLoggedUser()).get();
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

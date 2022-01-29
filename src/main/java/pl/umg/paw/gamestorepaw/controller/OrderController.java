package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.umg.paw.gamestorepaw.model.Order;
import pl.umg.paw.gamestorepaw.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public String showAllOrders(Model model){
        model.addAttribute("orders", orderService.findAllNotSended());
        return "/orders/orders";
    }

    @GetMapping("/send/{id}")
    public String sendTheOrder(@PathVariable Long id, Model model){
        if(!orderService.findById(id).isPresent() || orderService.findById(id).get().getStatus().equals("Sended")){
            return "/orders/orders";
        }
        Order order = orderService.findById(id).get();
        order.setStatus("Sended");
        orderService.update(order);
        model.addAttribute("order", order);
        return "/orders/send";
    }

    @PostMapping("/send/{id}")
    public String setThePackageNumber(@PathVariable Long id, Long packageNumber, Model model){
        if(!orderService.findById(id).isPresent() || orderService.findById(id).get().getStatus().equals("Sended")){
            return "/orders/orders";
        }
        if(packageNumber.toString().isEmpty() || packageNumber.toString().length()>3 || packageNumber.toString().length()<30){
            model.addAttribute("alert", "Package number is wrong");
            return sendTheOrder(id, model);
        }
        Order order = orderService.findById(id).get();
        order.setPackageNumber(packageNumber);
        orderService.update(order);
        return "redirect:/orders/orders";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        if(!orderService.findById(id).isPresent() || orderService.findById(id).get().getStatus().equals("Sended")){
            return "/orders/orders";
        }
        orderService.deleteById(id);
        return "redirect:/orders/orders";
    }
}

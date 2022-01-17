package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.umg.paw.gamestorepaw.model.MyUserDetails;
import pl.umg.paw.gamestorepaw.model.Repair;
import pl.umg.paw.gamestorepaw.model.User;
import pl.umg.paw.gamestorepaw.service.RepairService;
import pl.umg.paw.gamestorepaw.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/services")
public class RepairController {
    @Autowired
    private RepairService service;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getAllRepairs(Model model) {
        model.addAttribute("repairList",service.findAllNotSended());
        return "/services/list";
    }

    @GetMapping("/add")
    public String getSaveRepairForm() {
        return "/services/add";
    }

    @PostMapping("/add")
    public String saveRepair(Repair repair){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email;
        if (principal instanceof MyUserDetails) {
            email = ((MyUserDetails)principal).getUsername();
        } else {
            email = principal.toString();
        }
        repair.setUser(userService.findByEmail(email).get());
        repair.setStatus("Waiting");
        service.save(repair);
        return "/users/account";
    }

    @GetMapping("/delete/{id}")
    public void deleteRepair(@PathVariable Long id) {
        if (service.getById(id).isPresent()) {
            service.deleteById(id);
        }
    }

    @GetMapping("/answer/{id}")
    public String getRepairAnswerForm(@PathVariable Long id, Model model) {
        model.addAttribute("repair", service.getById(id).get());
        return "/services/answer";
    }

    @GetMapping("/answer/update/{id}")
    public String getRepairAnswerForm(@PathVariable Long id, Integer price) {
        Repair repair = service.getById(id).get();
        repair.setPrice(price);
        repair.setStatus("Waiting for payment");
        service.update(repair);
        return "redirect:/services/list";
    }

    @GetMapping("/pay/{id}")
    public String getRepairPayForm(@PathVariable Long id, Model model) {
        model.addAttribute("repair", service.getById(id).get());
        return "/services/endPay";
    }

    @GetMapping("/endPay/{id}")
    public String repairEndPay(@PathVariable Long id) {
        Repair repair = service.getById(id).get();
        repair.setStatus("Payed");
        service.update(repair);
        return "redirect:/users/account";
    }

    @GetMapping("/send/{id}")
    public String repairSendForm(@PathVariable Long id, Model model) {
        model.addAttribute("repair", service.getById(id).get());
        return "/services/send";
    }

    @GetMapping("/endSend/{id}")
    public String repairEndSend(@PathVariable Long id, Long packageNumber){
        Repair repair = service.getById(id).get();
        repair.setPackageNumber(packageNumber);
        repair.setStatus("Sended");
        service.update(repair);
        return "redirect:/services/list";
    }
}

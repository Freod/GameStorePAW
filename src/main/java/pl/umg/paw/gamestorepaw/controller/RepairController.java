package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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
    public List<Repair> getAllRepairs() {
        return service.findAll();
    }

    @GetMapping("/add")
    public String getSaveRepairForm() {
        return "/services/add";
    }

    @PostMapping("/add")
    public void saveRepair(Repair repair){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email;
        if (principal instanceof MyUserDetails) {
            email = ((MyUserDetails)principal).getUsername();
        } else {
            email = principal.toString();
        }
        repair.setUser(userService.findByEmail(email).get());
        service.save(repair);
    }

    @GetMapping("/delete/{id}")
    public void deleteRepair(@PathVariable Long id) {
        if (service.getById(id).isPresent()) {
            service.deleteById(id);
        }
    }
}

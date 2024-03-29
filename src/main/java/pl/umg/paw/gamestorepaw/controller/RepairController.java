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
        model.addAttribute("repairList", service.findAllNotSended());
        return "/services/list";
    }

    @GetMapping("/add")
    public String getSaveRepairForm(Model model) {
        return "/services/add";
    }

    @PostMapping("/add")
    public String saveRepair(Repair repair, Model model) {
        if (repair.getTitle().isEmpty() || repair.getTitle().length()>255 || repair.getDescription().isEmpty() || repair.getDescription().length()>255 || repair.getPackageNumber().describeConstable().isEmpty() || repair.getPackageNumber().toString().length()>30 || repair.getPackageNumber().toString().length()<3) {
            model.addAttribute("repair", repair);
            if (repair.getTitle().isEmpty())
                model.addAttribute("alert", "Title can't be empty.");
            else if(repair.getTitle().length()>255){
                model.addAttribute("alert", "Title length can't be more than 255.");
            }
            else if (repair.getDescription().isEmpty())
                model.addAttribute("alert", "Description can't be empty.");
            else if(repair.getDescription().length()>255){
                model.addAttribute("alert", "Description length can't be more than 255.");
            }
            else if(repair.getPackageNumber().toString().length()>30) {
                model.addAttribute("alert", "Package Number length can't be more than 30.");
            }
            else if(repair.getPackageNumber().toString().length()<3) {
                model.addAttribute("alert", "Package Number length can't be less than 3.");
            }
            else
                model.addAttribute("alert", "Package Number can't be empty.");
            return getSaveRepairForm(model);
        }
        if (repair.getPrice() != null) {
            repair.setPrice(null);
        }
        if (repair.getPackageNumber() < 0) {
            repair.setPackageNumber(repair.getPackageNumber() * (-1));
        }
        if (repair.getId() != null) {
            repair.setId(null);
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email;
        if (principal instanceof MyUserDetails) {
            email = ((MyUserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }
        repair.setUser(userService.findByEmail(email).get());
        repair.setStatus("Waiting");
        service.save(repair);
        return "redirect:/users/account";
    }

    @GetMapping("/delete/{id}")
    public void deleteRepair(@PathVariable Long id) {
        if (service.getById(id).isPresent()) {
            if (!service.getById(id).get().getStatus().equals("Waiting"))
                return;
            service.deleteById(id);
        }
    }

    @GetMapping("/answer/{id}")
    public String getRepairAnswerForm(@PathVariable Long id, Model model) {
        if(!service.getById(id).isPresent())
            return "/services/list";
        model.addAttribute("repair", service.getById(id).get());
        return "/services/answer";
    }

    @GetMapping("/answer/update/{id}")
    public String getRepairAnswerForm(@PathVariable Long id, Integer price, Model model) {
        if (!service.getById(id).isPresent() || !service.getById(id).get().getStatus().equals("Waiting"))
            return "/services/list";
        Repair repair = service.getById(id).get();
        if (price==null || price < 1 || price > 999999) {
            model.addAttribute("alert", "Price range is between 1 and 999999");
            model.addAttribute("repair", service.getById(id).get());
            System.out.println(model);
            return getRepairAnswerForm(id, model);
        }
        repair.setPrice(price);
        repair.setStatus("Waiting for payment");
        service.update(repair);
        return "redirect:/services/list";
    }

    @GetMapping("/pay/{id}")
    public String getRepairPayForm(@PathVariable Long id, Model model) {
        if (!service.getById(id).isPresent())
            return "/users/account";
        model.addAttribute("repair", service.getById(id).get());
        return "/services/endPay";
    }

    @GetMapping("/endPay/{id}")
    public String repairEndPay(@PathVariable Long id) {
        if (!service.getById(id).isPresent() || !service.getById(id).get().getStatus().equals("Waiting for payment"))
            return "/users/account";
        Repair repair = service.getById(id).get();
        repair.setStatus("Payed");
        service.update(repair);
        return "redirect:/users/account";
    }

    @GetMapping("/send/{id}")
    public String repairSendForm(@PathVariable Long id, Model model) {
        if (!service.getById(id).isPresent())
            return "/services/list";
        model.addAttribute("repair", service.getById(id).get());
        return "/services/send";
    }

    @GetMapping("/endSend/{id}")
    public String repairEndSend(@PathVariable Long id, Long packageNumber, Model model) {
        if (!service.getById(id).isPresent() || !service.getById(id).get().getStatus().equals("Payed"))
            return "/services/list";
        if (packageNumber.toString().length() < 3 || packageNumber.toString().length() > 20 || packageNumber.toString().isEmpty()) {
            model.addAttribute("alert", "Package number is wrong");
            model.addAttribute("repair", service.getById(id).get());
            return "/services/send";
        }
        Repair repair = service.getById(id).get();
        repair.setPackageNumber(packageNumber);
        repair.setStatus("Sended");
        service.update(repair);
        return "redirect:/services/list";
    }
}

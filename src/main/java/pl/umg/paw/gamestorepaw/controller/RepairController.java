package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.umg.paw.gamestorepaw.model.Repair;
import pl.umg.paw.gamestorepaw.service.RepairService;

import java.util.List;

@Controller
@RequestMapping("/services")
public class RepairController {
    @Autowired
    private RepairService service;

    @GetMapping(value = "/list")
    public List<Repair> getAllRepairs() {
        return service.findAll();
    }

    @PostMapping(value = "/add")
    public void saveRepair(Repair repair) {
        //TODO:exceptions
        service.save(repair);
    }

    @PutMapping(value = "/update/{id}")
    public void updateRepair(@PathVariable Long id, Repair repair) {
        //TODO:exceptions
        service.update(repair);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteRepair(@PathVariable Long id) {
        if (service.getById(id).isPresent()) {
            service.deleteById(id);
        }
    }
}

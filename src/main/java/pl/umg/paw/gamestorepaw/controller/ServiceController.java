package pl.umg.paw.gamestorepaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.umg.paw.gamestorepaw.model.Service;
import pl.umg.paw.gamestorepaw.service.impl.ServiceServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    private ServiceServiceImpl service;

    @GetMapping(value = "/list")
    public List<Service> getAllServices() {
        return service.findAll();
    }

    @PostMapping(value = "/add")
    public Service saveService(@RequestBody Service serviceModel) {
        //TODO:exceptions
        return service.save(serviceModel);
    }

    @PutMapping(value = "/update/{id}")
    public Service updateService(@PathVariable Long id, @RequestBody Service serviceModel) {
        //TODO:exceptions
        return service.update(serviceModel);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteService(@PathVariable Long id) {
        if (service.getById(id).isPresent()) {
            service.deleteById(id);
        }
    }
}

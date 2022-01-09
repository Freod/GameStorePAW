package pl.umg.paw.gamestorepaw.service.service;

import pl.umg.paw.gamestorepaw.model.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceService {
    List<Service> findAll();
    Optional<Service> getById(Long id);
    Service save(Service serviceModel);
    Service update(Service serviceModel);
    void deleteById(Long id);
}

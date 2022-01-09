package pl.umg.paw.gamestorepaw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umg.paw.gamestorepaw.repository.ServiceRepository;
import pl.umg.paw.gamestorepaw.service.service.ServiceService;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository repository;

    @Override
    public List<pl.umg.paw.gamestorepaw.model.Service> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<pl.umg.paw.gamestorepaw.model.Service> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public pl.umg.paw.gamestorepaw.model.Service save(pl.umg.paw.gamestorepaw.model.Service serviceModel) {
        return repository.save(serviceModel);
    }

    @Override
    public pl.umg.paw.gamestorepaw.model.Service update(pl.umg.paw.gamestorepaw.model.Service serviceModel) {
        return repository.save(serviceModel);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

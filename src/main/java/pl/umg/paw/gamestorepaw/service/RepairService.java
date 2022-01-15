package pl.umg.paw.gamestorepaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umg.paw.gamestorepaw.model.Repair;
import pl.umg.paw.gamestorepaw.model.User;
import pl.umg.paw.gamestorepaw.repository.RepairRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RepairService {
    @Autowired
    RepairRepository repository;

    public List<Repair> findAll() {
        return repository.findAll();
    }

    public void save(Repair repairModel) {
        repository.save(repairModel);
    }

    public void update(Repair repairModel) {
        repository.save(repairModel);
    }

    public Optional<Repair> getById(Long id) {
        return Optional.of(repository.getById(id));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Repair> findAllByUser(User user){return repository.findAllByUser(user);}
}

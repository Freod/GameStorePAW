package pl.umg.paw.gamestorepaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umg.paw.gamestorepaw.model.User;
import pl.umg.paw.gamestorepaw.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public void save(User user){
        repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}

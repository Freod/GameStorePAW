package pl.umg.paw.gamestorepaw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umg.paw.gamestorepaw.model.User;
import pl.umg.paw.gamestorepaw.repository.UserRepository;
import pl.umg.paw.gamestorepaw.service.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String username) {
        System.out.println(repository.findByEmail(username));
        return repository.findByEmail(username);
    }
}

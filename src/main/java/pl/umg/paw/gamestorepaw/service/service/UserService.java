package pl.umg.paw.gamestorepaw.service.service;

import pl.umg.paw.gamestorepaw.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> getById(Long id);
    User save(User user);
    User update(User user);
    void deleteById(Long id);
    Optional<User> findByEmail(String username);
}

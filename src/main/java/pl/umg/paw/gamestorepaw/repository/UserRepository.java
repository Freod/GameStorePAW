package pl.umg.paw.gamestorepaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.umg.paw.gamestorepaw.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String username);
//    Optional<User> findById(Long id);
}

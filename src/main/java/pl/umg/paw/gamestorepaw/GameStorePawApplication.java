package pl.umg.paw.gamestorepaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.umg.paw.gamestorepaw.repository.UserRepository;

@SpringBootApplication
public class GameStorePawApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameStorePawApplication.class, args);
    }

}

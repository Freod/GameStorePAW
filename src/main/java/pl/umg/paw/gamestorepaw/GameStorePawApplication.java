package pl.umg.paw.gamestorepaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import pl.umg.paw.gamestorepaw.repository.UserRepository;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class GameStorePawApplication {
    public static void main(String[] args) {
        SpringApplication.run(GameStorePawApplication.class, args);
    }
}

package pl.umg.paw.gamestorepaw.service.service;

import pl.umg.paw.gamestorepaw.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameService{
    List<Game> findAll();
    Optional<Game> getById(Long id);
    Game save(Game game);
    Game update(Game game);
    void deleteById(Long id);
}

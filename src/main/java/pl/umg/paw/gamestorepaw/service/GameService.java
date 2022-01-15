package pl.umg.paw.gamestorepaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umg.paw.gamestorepaw.model.Game;
import pl.umg.paw.gamestorepaw.repository.GameRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    GameRepository repository;

    public void save(Game game){
        repository.save(game);
    }

    public void update(Game game) {
        repository.save(game);
    }

    public Optional<Game> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        deleteById(id);
    }

    public List<Game> findAll(){
        return repository.findAll();
    }

    public List<Game> findAllNotSold(){return repository.findAllNotSold();}
}

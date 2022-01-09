package pl.umg.paw.gamestorepaw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umg.paw.gamestorepaw.model.Game;
import pl.umg.paw.gamestorepaw.repository.GameRepository;
import pl.umg.paw.gamestorepaw.service.service.GameService;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository repository;

    @Override
    public List<Game> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Game> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Game save(Game game) {
        return repository.save(game);
    }

    @Override
    public Game update(Game game) {
        return repository.save(game);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

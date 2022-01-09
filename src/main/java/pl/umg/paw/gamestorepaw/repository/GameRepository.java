package pl.umg.paw.gamestorepaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.umg.paw.gamestorepaw.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}

package pl.umg.paw.gamestorepaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.umg.paw.gamestorepaw.model.Game;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    @Query(value = "select * from gamestorepaw.game where gamestorepaw.game.game_id not in(select games_game_id from gamestorepaw.orders inner join gamestorepaw.orders_games on order_id = order_order_id);", nativeQuery = true)
    List<Game> findAllNotSold();
}

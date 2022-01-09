package pl.umg.paw.gamestorepaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.umg.paw.gamestorepaw.model.Game;
import pl.umg.paw.gamestorepaw.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

}

package pl.umg.paw.gamestorepaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.umg.paw.gamestorepaw.model.Repair;
import pl.umg.paw.gamestorepaw.model.User;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {
    List<Repair> findAllByUser(User user);
    @Query("select repair from Repair repair where repair.status not like 'Sended'")
    List<Repair> findAllNotSended();
}

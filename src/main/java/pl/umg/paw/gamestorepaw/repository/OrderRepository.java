package pl.umg.paw.gamestorepaw.repository;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.umg.paw.gamestorepaw.model.Order;
import pl.umg.paw.gamestorepaw.model.User;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUser(User user);
    @Query("select order1 from Order order1 where order1.status not like 'Sended'")
    List<Order> findAllNotSended();
}

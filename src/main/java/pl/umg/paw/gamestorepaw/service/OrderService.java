package pl.umg.paw.gamestorepaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umg.paw.gamestorepaw.model.Order;
import pl.umg.paw.gamestorepaw.model.User;
import pl.umg.paw.gamestorepaw.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository repository;

    public List<Order> findAll(){return repository.findAll();}

    public List<Order> findAllByUser(User user){
        return repository.findAllByUser(user);
    }

    public void save(Order order){
        repository.save(order);
    }
}

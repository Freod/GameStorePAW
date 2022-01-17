package pl.umg.paw.gamestorepaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umg.paw.gamestorepaw.model.Order;
import pl.umg.paw.gamestorepaw.model.User;
import pl.umg.paw.gamestorepaw.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

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

    public Optional<Order> findById(Long id){
        return repository.findById(id);
    }

    public void update(Order order){
        repository.save(order);
    }

    public List<Order> findAllNotSended(){
        return repository.findAllNotSended();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}

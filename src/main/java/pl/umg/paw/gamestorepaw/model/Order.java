package pl.umg.paw.gamestorepaw.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;
    @OneToOne
    private User user;
    @OneToMany
    private List<Game> games;

    public Order() {
    }

    public Order(User user, List<Game> games) {
        this.user = user;
        this.games = games;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", games=" + games +
                '}';
    }
}

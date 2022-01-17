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
    @Column(name="order_status")
    private String status;
    @Column(name="order_packageNumber")
    private Long packageNumber;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(Long packageNumber) {
        this.packageNumber = packageNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", packageNumber=" + packageNumber +
                ", user=" + user +
                ", games=" + games +
                '}';
    }
}

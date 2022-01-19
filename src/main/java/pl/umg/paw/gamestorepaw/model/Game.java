package pl.umg.paw.gamestorepaw.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="game")
public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="game_id")
    private Long id;
    @Column(name="game_name")
    private String name;
    @Column(name="game_platform")
    private String platform;
    @Column(name="game_price")
    private double price;
    @Column(name = "game_image")
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", platform='" + platform + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}

package pl.umg.paw.gamestorepaw.model;

import javax.persistence.*;

@Entity
@Table(name = "repair")
public class Repair {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "repair_id")
    private Long id;
    @Column(name="repair_title")
    private String title;
    @Column(name="repair_description")
    private String description;
    @Column(name="repair_packageNumber")
    private Long packageNumber;
    @Column(name="repair_status")
    private String status;
    @Column(name="repair_price")
    private Integer price;
    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(Long packageNumber) {
        this.packageNumber = packageNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

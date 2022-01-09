package pl.umg.paw.gamestorepaw.model;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long id;
    @Column(name="service_title")
    private String title;
    @Column(name="service_description")
    private String description;
    //TODO:Address
//    @Column(name="service_title")
//    private Address address;
    @Column(name="service_packageNumber")
    private String packageNumber;

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

    public String getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(String packageNumber) {
        this.packageNumber = packageNumber;
    }
}

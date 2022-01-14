package pl.umg.paw.gamestorepaw.model;

import javax.persistence.*;

@Entity
@Table(name="image")
public class Image {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="image_id")
    private Long id;
    @Column(name="image_link")
    private String link;
}

package pl.umg.paw.gamestorepaw.model;

import javax.persistence.*;

@Entity
@Table(name="GameTransaction")
public class GameTransaction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="game_transaction_id")
    private Long id;
    @Column(name="game_transaction_userid")
    private Long userId;
    @Column(name="game_transaction_repairid")
    private Long gameId;
}

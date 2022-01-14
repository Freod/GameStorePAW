package pl.umg.paw.gamestorepaw.model;

import javax.persistence.*;

@Entity
@Table(name="RepairTransaction")
public class RepairTransaction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="repair_transaction_id")
    private Long id;
    @Column(name="repair_transaction_userid")
    private Long userId;
    @Column(name="repair_transaction_repairid")
    private Long repairId;
}

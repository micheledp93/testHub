package it.unikey.testhub_server.DAL.entity;

import it.unikey.testhub_server.DAL.enums.EStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    private Status status;

    @Column(nullable = false)
    private LocalDate sessionDate;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    @JoinColumn(nullable = false)
    private Assessment assessment;

    @OneToMany(mappedBy = "session",
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private List<Dispense> dispenses;

}

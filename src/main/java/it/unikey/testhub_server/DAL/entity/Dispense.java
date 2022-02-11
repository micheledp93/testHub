package it.unikey.testhub_server.DAL.entity;

import it.unikey.testhub_server.DAL.enums.EStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
public class Dispense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Long result;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    private SessionEntity session;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    private UserEntity userEntity;


}
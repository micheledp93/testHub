package it.unikey.testhub_server.DAL.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true, nullable = false)
    private String mail;

    @OneToMany(mappedBy = "userEntity",
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    private List<Dispense> dispense;
}

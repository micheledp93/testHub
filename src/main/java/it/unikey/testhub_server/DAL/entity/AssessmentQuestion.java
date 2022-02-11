package it.unikey.testhub_server.DAL.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class AssessmentQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JoinColumn(nullable = false)
    private Assessment assessment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(nullable = false)
    private Question question;

    @Column(nullable = false)
    private Double percentage_weight;
}


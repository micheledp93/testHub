package it.unikey.testhub_server.DAL.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = "assessmentQuestion")
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double maxScore;

    @Column(nullable = false)
    private Boolean given;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private List<Tag> tag = new ArrayList<>();

    @OneToMany(mappedBy = "assessment",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private List<AssessmentQuestion> assessmentQuestions = new ArrayList<>();

    @OneToMany(mappedBy = "assessment",
            cascade = {
                    CascadeType.MERGE
            })
    private List<SessionEntity> sessionEntities = new ArrayList<>();

}

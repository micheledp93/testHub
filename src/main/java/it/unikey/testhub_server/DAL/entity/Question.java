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
@ToString(exclude = "assessmentQuestions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private Boolean given;

    @Column(nullable = false)
    private Boolean mandatory;

    @Column(nullable = false)
    private Boolean active;

    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Answer> answers = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private List<Tag> tag = new ArrayList<>();


    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AssessmentQuestion> assessmentQuestions = new ArrayList<>();

}

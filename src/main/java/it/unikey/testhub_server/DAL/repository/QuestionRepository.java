package it.unikey.testhub_server.DAL.repository;

import it.unikey.testhub_server.DAL.entity.AssessmentQuestion;
import it.unikey.testhub_server.DAL.entity.Question;
import it.unikey.testhub_server.DAL.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    Page<Question> findAllByActiveIsTrueOrderByIdDesc(Pageable page);

    Long countQuestionByActiveIsTrue();

    List<Question> findQuestionsByTagAndActiveIsTrueOrderByIdDesc(Tag tag, Pageable page);

    Long countQuestionsByTagAndActiveIsTrue(Tag tag);

    @Modifying
    @Query("update Question q set q.active=0 where q.id=:id")
    void logicDeleteById(@Param("id") Long id);

    List<Question> findQuestionsByAssessmentQuestions(AssessmentQuestion assessmentQuestion);
}
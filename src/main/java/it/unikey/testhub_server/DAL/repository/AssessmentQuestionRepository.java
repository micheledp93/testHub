package it.unikey.testhub_server.DAL.repository;

import it.unikey.testhub_server.DAL.entity.AssessmentQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentQuestionRepository extends JpaRepository<AssessmentQuestion, Long> {

    void deleteAllByAssessment_Id(Long id);

}

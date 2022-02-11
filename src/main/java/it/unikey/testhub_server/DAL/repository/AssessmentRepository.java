package it.unikey.testhub_server.DAL.repository;

import it.unikey.testhub_server.DAL.entity.Assessment;
import it.unikey.testhub_server.DAL.entity.SessionEntity;
import it.unikey.testhub_server.DAL.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {

    Page<Assessment> findAll(Pageable page);

    List<Assessment> findAssessmentsByTag(Tag tag, Pageable page);

    Long countAssessmentsByTag(Tag tag);

    void deleteByIdAndGivenIsFalse(Long id);

    Assessment findAssessmentBySessionEntities(SessionEntity session);

}

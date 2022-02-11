package it.unikey.testhub_server.DAL.repository;

import it.unikey.testhub_server.DAL.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> getAnswersByQuestion_Id(Long id);

}

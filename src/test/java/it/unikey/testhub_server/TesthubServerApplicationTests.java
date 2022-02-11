package it.unikey.testhub_server;

import it.unikey.testhub_server.DAL.entity.*;
import it.unikey.testhub_server.DAL.enums.EStatus;
import it.unikey.testhub_server.DAL.repository.DispenseRepository;
import it.unikey.testhub_server.DAL.repository.QuestionRepository;
import it.unikey.testhub_server.DAL.repository.StatusRepository;
import it.unikey.testhub_server.DAL.repository.TagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TesthubServerApplicationTests {

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private StatusRepository statusRepository;

    @Test
    void saveQuestion() {
        Question question = new Question();
        question.setId(1L);
        question.setBody("domanda1");
        question.setMandatory(true);
        System.out.println(question);
        if (question.getId() == null) {
            System.out.println("No question found");
        }

        List<Answer> answers = new ArrayList<>();

        Answer a1 = new Answer();
        a1.setId(1L);
        a1.setBody("risp1");
        a1.setCorrect(false);
        answers.add(a1);
        Answer a2 = new Answer();
        a2.setId(2L);
        a2.setBody("risp2");
        a2.setCorrect(false);
        answers.add(a2);
        Answer a3 = new Answer();
        a3.setId(3L);
        a3.setBody("risp3");
        a3.setCorrect(false);
        answers.add(a3);
        Answer a4 = new Answer();
        a4.setId(4L);
        a4.setBody("risp4");
        a4.setCorrect(true);
        answers.add(a4);
        System.out.println(answers);
        if (answers.size() != 4 ) {
            System.out.println("Missing answers");
        }
        int count = 0;
        for (Answer a: answers) {
            if (a.getCorrect().equals(true)){
                count++;
            }
        }
        if (count != 1){
            System.out.println("answers error");
        }

        List<Tag> tags = new ArrayList<>();
        Tag t = new Tag();
        t.setId(1L);
        t.setDescription("html");
        tags.add(t);
        System.out.println(tags);
        if (tags.size() <1) {
            System.out.println("No tags found");
        }
        question.setActive(true);
        question.setGiven(false);
        for (Answer answer : answers) {
            answer.setQuestion(question);
        }
        question.setAnswers(answers);
        //questionRepository.save(question);
        //System.out.println("question saved");
        for (Tag tag : tags) {
            tag.getQuestions().add(question);
            question.getTag().add(tag);
            //tagRepository.save(tag);
        }

    }

}

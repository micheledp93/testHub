package it.unikey.testhub_server.BLL.service.impl;

import it.unikey.testhub_server.BLL.dto.request.QuestionRequestDTO;
import it.unikey.testhub_server.BLL.dto.response.QuestionPaginatorResponseDTO;
import it.unikey.testhub_server.BLL.dto.response.QuestionResponseDTO;
import it.unikey.testhub_server.BLL.mapper.AnswerRequestMapper;
import it.unikey.testhub_server.BLL.mapper.QuestionRequestMapper;
import it.unikey.testhub_server.BLL.mapper.QuestionResponseMapper;
import it.unikey.testhub_server.BLL.mapper.TagRequestMapper;
import it.unikey.testhub_server.BLL.service.QuestionService;
import it.unikey.testhub_server.DAL.entity.Answer;
import it.unikey.testhub_server.DAL.entity.Question;
import it.unikey.testhub_server.DAL.entity.Tag;
import it.unikey.testhub_server.DAL.repository.QuestionRepository;
import it.unikey.testhub_server.DAL.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionResponseMapper questionResponseMapper;
    private final TagRepository tagRepository;
    private final QuestionRequestMapper questionRequestMapper;
    private final TagRequestMapper tagRequestMapper;
    private final AnswerRequestMapper answerRequestMapper;

    @Override
    public QuestionPaginatorResponseDTO findAll(Pageable page) {
        QuestionPaginatorResponseDTO questionPaginatorResponseDTO = new QuestionPaginatorResponseDTO();
        questionPaginatorResponseDTO.setQuestionResponseDTOList(questionResponseMapper.asDTOList(questionRepository.findAllByActiveIsTrueOrderByIdDesc(page).getContent()));
        questionPaginatorResponseDTO.setQuestionQuantity(questionRepository.countQuestionByActiveIsTrue());
        return questionPaginatorResponseDTO;
    }

    @Override
    public QuestionResponseDTO findById(Long id) {
        return questionResponseMapper.asDTO(questionRepository.getById(id));
    }

    @Override
    public void saveQuestion(QuestionRequestDTO questionRequestDTO) {
        Question question = questionRequestMapper.asEntity(questionRequestDTO);
//        if (question.getId() == null){
//            System.out.println("No question found");
//            return false;
//        }
        List<Answer> answers = answerRequestMapper.asEntityList(questionRequestDTO.getAnswers());
//        if (answers.size() != 4 ) {
//            System.out.println("Missing answers");
//            return  false;
//        }
//        int count = 0;
//        for (Answer a: answers) {
//            if (a.getCorrect().equals(true)){
//                count++;
//            }
//        }
//        if (count != 1){
//            System.out.println("answers error");
//            return  false;
//        }
        List<Tag> tags = tagRequestMapper.asEntityList(questionRequestDTO.getTags());
//        if (tags.size() <1){
//            System.out.println("No tags found");
//            return false;
//        }
        question.setActive(true);
        question.setGiven(false);
        for (Answer answer : answers) {
            answer.setQuestion(question);
        }
        question.setAnswers(answers);
        questionRepository.save(question);
        for (Tag tag : tags) {
            tag.getQuestions().add(question);
            question.getTag().add(tag);
            tagRepository.save(tag);
        }
//        return true;
    }

    @Override
    public QuestionPaginatorResponseDTO findQuestionsByTags(List<Long> tagIds, Pageable page) {
        QuestionPaginatorResponseDTO questionPaginatorResponseDTO = new QuestionPaginatorResponseDTO();
        List<Tag> tags = tagRepository.findAllById(tagIds);
        List<Question> questions = questionRepository.findQuestionsByTagAndActiveIsTrueOrderByIdDesc(tags.get(0), page);
        if (tags.size() == 1) {
            List<QuestionResponseDTO> questionResponseDTOS = questionResponseMapper.asDTOList(questions);
            questionPaginatorResponseDTO.setQuestionResponseDTOList(questionResponseDTOS);
            questionPaginatorResponseDTO.setQuestionQuantity(questionRepository.countQuestionsByTagAndActiveIsTrue(tags.get(0)));
            return questionPaginatorResponseDTO;
        } else if (tags.size() > 1) {
            for (int i = 1; i < tags.size(); i++) {
                List<Question> questionTemp = new ArrayList<>();
                for (Question question : questionRepository.findQuestionsByTagAndActiveIsTrueOrderByIdDesc(tags.get(i), page)) {
                    if (questions.contains(question) && !questionTemp.contains(question)) {
                        questionTemp.add(question);
                    }
                }
                questions = questionTemp;
            }
            List<QuestionResponseDTO> questionResponseDTOS = questionResponseMapper.asDTOList(questions);
            questionPaginatorResponseDTO.setQuestionResponseDTOList(questionResponseDTOS);
            questionPaginatorResponseDTO.setQuestionQuantity(questionRepository.countQuestionsByTagAndActiveIsTrue(tags.get(tags.size() - 1)));
            return questionPaginatorResponseDTO;
        }
        return null;
    }

    @Override
    public void logicDeleteById(Long id) {
        questionRepository.logicDeleteById(id);
    }
}

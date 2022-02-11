package it.unikey.testhub_server.BLL.service.impl;

import it.unikey.testhub_server.BLL.dto.request.AssessmentRequestDTO;
import it.unikey.testhub_server.BLL.dto.request.QuestionRequestDTO;
import it.unikey.testhub_server.BLL.dto.response.QuestionResponseDTO;
import it.unikey.testhub_server.BLL.mapper.*;
import it.unikey.testhub_server.BLL.service.AssessmentService;
import it.unikey.testhub_server.DAL.entity.Assessment;
import it.unikey.testhub_server.DAL.entity.AssessmentQuestion;
import it.unikey.testhub_server.DAL.entity.Question;
import it.unikey.testhub_server.DAL.entity.Tag;
import it.unikey.testhub_server.DAL.repository.AssessmentQuestionRepository;
import it.unikey.testhub_server.DAL.repository.AssessmentRepository;
import it.unikey.testhub_server.DAL.repository.QuestionRepository;
import it.unikey.testhub_server.DAL.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.unikey.testhub_server.BLL.dto.response.AssessmentPaginatorResponseDTO;
import it.unikey.testhub_server.BLL.dto.response.AssessmentResponseDTO;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentRepository assessmentRepository;
    private final AssessmentRequestMapper assessmentRequestMapper;
    private final QuestionRequestMapper questionRequestMapper;
    private final TagRequestMapper tagRequestMapper;
    private final AssessmentQuestionRepository assessmentQuestionRepository;
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;
    private final TagResponseMapper tagResponseMapper;
    private final AssessmentResponseMapper assessmentResponseMapper;
    private final QuestionResponseMapper questionResponseMapper;

    @Override
    public AssessmentResponseDTO findById(Long id) {
        Assessment assessment = assessmentRepository.findById(id).get();
        AssessmentResponseDTO assessmentResponseDTO = assessmentResponseMapper.asDTO(assessment);
        assessmentResponseDTO.setTags(tagResponseMapper.asDTOList(assessment.getTag()));
        List<QuestionResponseDTO> questionResponseDTOs = new ArrayList<>();
        for (AssessmentQuestion assessmentQuestion : assessment.getAssessmentQuestions()) {
            List<Question> questionList = questionRepository.findQuestionsByAssessmentQuestions(assessmentQuestion);
            for (Question question : questionList) {
                QuestionResponseDTO qrDTO = questionResponseMapper.asDTO(question);
                qrDTO.setPercentage( assessmentQuestion.getPercentage_weight());
                questionResponseDTOs.add(qrDTO);
            }
        }
        assessmentResponseDTO.setQuestions(questionResponseDTOs);
        return assessmentResponseDTO;
    }

    @Override
    public AssessmentPaginatorResponseDTO findAll(Pageable page) {
        AssessmentPaginatorResponseDTO assessmentPaginatorResponseDTO = new AssessmentPaginatorResponseDTO();
        List<Assessment> assessments = assessmentRepository.findAll(page).getContent();
        List<AssessmentResponseDTO> assessmentResponseDTOList = new ArrayList<>();
        for (Assessment assessment : assessments) {
            AssessmentResponseDTO assessmentResponseDTO = assessmentResponseMapper.asDTO(assessment);
            assessmentResponseDTO.setTags(tagResponseMapper.asDTOList(assessment.getTag()));
            assessmentResponseDTOList.add(assessmentResponseDTO);
        }
        assessmentPaginatorResponseDTO.setAssessmentResponseDTOList(assessmentResponseDTOList);
        assessmentPaginatorResponseDTO.setAssessmentQuantity(assessmentRepository.count());
        return assessmentPaginatorResponseDTO;
    }

    @Override
    public AssessmentPaginatorResponseDTO findAssessmentsByTags(List<Long> tagIds, Pageable page) {
        AssessmentPaginatorResponseDTO assessmentPaginatorResponseDTO = new AssessmentPaginatorResponseDTO();
        List<Tag> tags = tagRepository.findAllById(tagIds);
        List<Assessment> assessments = assessmentRepository.findAssessmentsByTag(tags.get(0), page);
        if (tags.size() == 1) {
            List<AssessmentResponseDTO> assessmentResponseDTOList = assessmentResponseMapper.asDTOList(assessments);
            assessmentPaginatorResponseDTO.setAssessmentResponseDTOList(assessmentResponseDTOList);
            assessmentPaginatorResponseDTO.setAssessmentQuantity(assessmentRepository.countAssessmentsByTag(tags.get(0)));
            return assessmentPaginatorResponseDTO;
        } else if (tags.size() > 1) {
            for (int i = 1; i < tags.size(); i++) {
                List<Assessment> assessmentTemp = new ArrayList<>();
                for (Assessment assessment : assessmentRepository.findAssessmentsByTag(tags.get(i), page)) {
                    if (assessments.contains(assessment) && !assessmentTemp.contains(assessment)) {
                        assessmentTemp.add(assessment);
                    }
                }
                assessments = assessmentTemp;
            }
            List<AssessmentResponseDTO> assessmentResponseDTOList = assessmentResponseMapper.asDTOList(assessments);
            assessmentPaginatorResponseDTO.setAssessmentResponseDTOList(assessmentResponseDTOList);
            assessmentPaginatorResponseDTO.setAssessmentQuantity(assessmentRepository.countAssessmentsByTag(tags.get(tags.size() - 1)));
            return assessmentPaginatorResponseDTO;
        }
        return null;
    }

    @Override
    public void deleteAssessmentById(Long id) {
        assessmentQuestionRepository.deleteAllByAssessment_Id(id);
        assessmentRepository.deleteByIdAndGivenIsFalse(id);
    }

    @Override
    public void saveAssessment(AssessmentRequestDTO assessmentRequestDTO) {
        Assessment assessment = assessmentRequestMapper.asEntity(assessmentRequestDTO);
        Double maxScore = 0.0;
        for (QuestionRequestDTO question : assessmentRequestDTO.getQuestions()) {
            maxScore += question.getPercentage();
        }
        assessment.setMaxScore(maxScore);
        assessment.setGiven(false);
        List<Tag> tags = tagRequestMapper.asEntityList(assessmentRequestDTO.getTags());
        assessmentRepository.save(assessment);
        for (QuestionRequestDTO question : assessmentRequestDTO.getQuestions()) {
            questionRepository.findById(question.getId()).get();
            AssessmentQuestion assessmentQuestion = new AssessmentQuestion();
            assessmentQuestion.setAssessment(assessment);
            assessmentQuestion.setPercentage_weight(question.getPercentage());
            assessmentQuestion.setQuestion(questionRequestMapper.asEntity(question));
            assessmentQuestionRepository.save(assessmentQuestion);
        }
        for (Tag tag : tags) {
            tag.getAssessments().add(assessment);
            assessment.getTag().add(tag);
            tagRepository.save(tag);
        }
    }
}



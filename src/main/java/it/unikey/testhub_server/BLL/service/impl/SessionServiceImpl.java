package it.unikey.testhub_server.BLL.service.impl;


import it.unikey.testhub_server.BLL.dto.request.SessionRequestDTO;
import it.unikey.testhub_server.BLL.dto.response.*;
import it.unikey.testhub_server.BLL.mapper.*;
import it.unikey.testhub_server.BLL.service.SessionService;
import it.unikey.testhub_server.DAL.entity.*;
import it.unikey.testhub_server.DAL.enums.EStatus;
import it.unikey.testhub_server.DAL.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final SessionResponseMapper sessionResponseMapper;
    private final AssessmentResponseMapper assessmentResponseMapper;
    private final QuestionRepository questionRepository;
    private final QuestionResponseMapper questionResponseMapper;
    private final SessionDetailResponseMapper sessionDetailResponseMapper;
    private final DispenseResponseMapper dispenseResponseMapper;
    private final UserResponseMapper userResponseMapper;
    private final SessionRequestMapper sessionRequestMapper;
    private final AssessmentRepository assessmentRepository;
    private final UserEntityRepository userEntityRepository;
    private final DispenseRepository dispenseRepository;
    private final StatusRepository statusRepository;

    @Override
    public SessionPaginatorResponseDTO findSessionsByStatus(Pageable pageable) {
        List<SessionEntity> sessionEntities = sessionRepository.findSessionEntitiesByStatus_descriptionOrStatus_DescriptionOrderByIdDesc(EStatus.ACTIVE.name(), EStatus.SENT.name(), pageable).getContent();
        List<SessionResponseDTO> sessionResponseDTOList = new ArrayList<>();
        for (SessionEntity sessionEntity : sessionEntities) {
            SessionResponseDTO sessionResponseDTO = sessionResponseMapper.asDTO(sessionEntity);
            sessionResponseDTO.setAssessmentResponseDTO(assessmentResponseMapper.asDTO(sessionEntity.getAssessment()));
            sessionResponseDTO.setSessionDate(sessionEntity.getSessionDate());
            sessionResponseDTOList.add(sessionResponseDTO);
        }
        SessionPaginatorResponseDTO sessionPaginatorResponseDTO = new SessionPaginatorResponseDTO();
        sessionPaginatorResponseDTO.setSessionResponseDTOList(sessionResponseDTOList);
        sessionPaginatorResponseDTO.setSessionQuantity(sessionRepository.countSessionEntitiesByStatus_descriptionOrStatus_description(EStatus.ACTIVE.toString(), EStatus.SENT.toString()));
        return sessionPaginatorResponseDTO;
    }

    @Override
    public SessionResponseDetailDTO findSessionEntityById(Long id) {

        SessionEntity session = sessionRepository.findById(id).get();
        SessionResponseDetailDTO sessionResponseDetailDTO = sessionDetailResponseMapper.asDTO(session);
        AssessmentResponseDTO assessmentResponseDTO = assessmentResponseMapper.asDTO(session.getAssessment());
        List<DispenseResponseDTO> dispenseResponseDTOList = new ArrayList<>();
        for (Dispense dispense : session.getDispenses()) {
            UserResponseDTO userResponseDTO = userResponseMapper.asDTO(dispense.getUserEntity());
            DispenseResponseDTO dispenseResponseDTO = dispenseResponseMapper.asDTO(dispense);
            dispenseResponseDTOList.add(dispenseResponseDTO);
        }
        sessionResponseDetailDTO.setDispenses(dispenseResponseDTOList);

        List<QuestionResponseDTO> questionResponseDTOs = new ArrayList<>();
        for (AssessmentQuestion assessmentQuestion : session.getAssessment().getAssessmentQuestions()) {
            List<Question> questionList = questionRepository.findQuestionsByAssessmentQuestions(assessmentQuestion);
            for (Question question : questionList) {
                QuestionResponseDTO qrDTO = questionResponseMapper.asDTO(question);
                qrDTO.setPercentage(assessmentQuestion.getPercentage_weight());
                questionResponseDTOs.add(qrDTO);
            }
            assessmentResponseDTO.setQuestions(questionResponseDTOs);
        }
        sessionResponseDetailDTO.setAssessmentResponseDTO(assessmentResponseDTO);
        return sessionResponseDetailDTO;
    }


    @Override
    public void saveSession(SessionRequestDTO sessionRequestDTO) {
        SessionEntity session = sessionRequestMapper.asEntity(sessionRequestDTO);
        Status status = new Status();
        status.setDescription(EStatus.ACTIVE.toString());
        statusRepository.save(status);
        session.setStatus(status);
        assessmentRepository.save(session.getAssessment());
        List<Dispense> dispenses = session.getDispenses();
        for (Dispense dispense : dispenses) {
            Status statusIna = new Status();
            statusIna.setDescription(EStatus.INACTIVE.toString());
            statusRepository.save(statusIna);
            dispense.setStatus(statusIna);
            userEntityRepository.save(dispense.getUserEntity());
            dispenseRepository.save(dispense);
        }
        sessionRepository.save(session);

    }
}

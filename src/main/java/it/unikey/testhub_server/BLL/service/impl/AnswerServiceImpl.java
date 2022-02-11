package it.unikey.testhub_server.BLL.service.impl;

import it.unikey.testhub_server.BLL.dto.response.AnswerResponseDTO;
import it.unikey.testhub_server.BLL.mapper.AnswerResponseMapper;
import it.unikey.testhub_server.BLL.service.AnswerService;
import it.unikey.testhub_server.DAL.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final AnswerResponseMapper answerResponseMapper;

    @Transactional(readOnly = true)
    public List<AnswerResponseDTO> findAnswersByQuestion_id(Long id) {
        return answerResponseMapper.asDTOList(answerRepository.getAnswersByQuestion_Id(id));
    }

    @Transactional(readOnly = true)
    public AnswerResponseDTO findById(Long id) {
        return answerResponseMapper.asDTO(answerRepository.getById(id));
    }


}
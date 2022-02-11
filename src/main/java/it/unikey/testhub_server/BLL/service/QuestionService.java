package it.unikey.testhub_server.BLL.service;

import it.unikey.testhub_server.BLL.dto.request.QuestionRequestDTO;
import it.unikey.testhub_server.BLL.dto.response.QuestionPaginatorResponseDTO;
import it.unikey.testhub_server.BLL.dto.response.QuestionResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {

    QuestionPaginatorResponseDTO findAll(Pageable page);
    QuestionResponseDTO findById(Long id);
    void saveQuestion(QuestionRequestDTO questionRequestDTO);
    void logicDeleteById(Long id);
    QuestionPaginatorResponseDTO findQuestionsByTags(List<Long> tagIds, Pageable page);

}

package it.unikey.testhub_server.BLL.service;

import it.unikey.testhub_server.BLL.dto.request.AssessmentRequestDTO;
import it.unikey.testhub_server.BLL.dto.response.AssessmentPaginatorResponseDTO;
import it.unikey.testhub_server.BLL.dto.response.AssessmentResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AssessmentService {

    AssessmentPaginatorResponseDTO findAll(Pageable page);
    AssessmentResponseDTO findById(Long id);
    AssessmentPaginatorResponseDTO findAssessmentsByTags(List<Long> tagIds, Pageable page);
    void deleteAssessmentById(Long id);
    void saveAssessment(AssessmentRequestDTO assessmentRequestDTO);

}

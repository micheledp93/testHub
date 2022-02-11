package it.unikey.testhub_server.BLL.service;

import it.unikey.testhub_server.BLL.dto.response.AnswerResponseDTO;

import java.util.List;

public interface AnswerService {

    List<AnswerResponseDTO> findAnswersByQuestion_id(Long id);
    AnswerResponseDTO findById(Long id);

}

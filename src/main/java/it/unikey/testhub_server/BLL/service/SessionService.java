package it.unikey.testhub_server.BLL.service;


import it.unikey.testhub_server.BLL.dto.request.SessionRequestDTO;
import it.unikey.testhub_server.BLL.dto.response.SessionPaginatorResponseDTO;
import it.unikey.testhub_server.BLL.dto.response.SessionResponseDTO;
import it.unikey.testhub_server.BLL.dto.response.SessionResponseDetailDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface SessionService {

    SessionPaginatorResponseDTO findSessionsByStatus(Pageable pageable);
   SessionResponseDetailDTO findSessionEntityById (Long id);


    void saveSession(SessionRequestDTO sessionRequestDTO);
}

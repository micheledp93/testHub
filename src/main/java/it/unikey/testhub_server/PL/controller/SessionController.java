package it.unikey.testhub_server.PL.controller;

import it.unikey.testhub_server.BLL.dto.request.SessionRequestDTO;
import it.unikey.testhub_server.BLL.dto.response.SessionPaginatorResponseDTO;
import it.unikey.testhub_server.BLL.dto.response.SessionResponseDetailDTO;
import it.unikey.testhub_server.BLL.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/session")
@CrossOrigin("http://localhost:4200")
public class SessionController {

    private final SessionService sessionService;

    @GetMapping
    public ResponseEntity<SessionPaginatorResponseDTO> getSessionsByStatus(Pageable pageable) {
        return new ResponseEntity<>(sessionService.findSessionsByStatus(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveSession(@RequestBody SessionRequestDTO sessionRequestDTO) {
        sessionService.saveSession(sessionRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SessionResponseDetailDTO> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(sessionService.findSessionEntityById(id), HttpStatus.OK);
    }
}

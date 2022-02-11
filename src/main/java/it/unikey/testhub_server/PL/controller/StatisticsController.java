package it.unikey.testhub_server.PL.controller;

import it.unikey.testhub_server.BLL.dto.response.SessionCountStatisticsDTO;
import it.unikey.testhub_server.BLL.dto.response.SessionPaginatorResponseDTO;
import it.unikey.testhub_server.BLL.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/statistics")
@CrossOrigin("http://localhost:4200")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping
    public ResponseEntity<SessionCountStatisticsDTO> getSessionsByStatus() {
        return new ResponseEntity<>(statisticsService.getCountSessionStatistics(), HttpStatus.OK);
    }

}

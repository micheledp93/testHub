package it.unikey.testhub_server.BLL.service.impl;

import it.unikey.testhub_server.BLL.dto.response.SessionCountStatisticsDTO;
import it.unikey.testhub_server.BLL.service.StatisticsService;
import it.unikey.testhub_server.DAL.enums.EStatus;
import it.unikey.testhub_server.DAL.repository.SessionRepository;
import it.unikey.testhub_server.DAL.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StatisticsServiceImpl implements StatisticsService {


    private final SessionRepository sessionRepository;
    private final StatusRepository statusRepository;

    @Override
    public SessionCountStatisticsDTO getCountSessionStatistics() {
        SessionCountStatisticsDTO sessionCountStatisticsDTO = new SessionCountStatisticsDTO();
        sessionCountStatisticsDTO.setSentSession(sessionRepository.countSessionEntitiesByStatus_Description(EStatus.SENT.toString()));
        sessionCountStatisticsDTO.setCompletedSession(sessionRepository.countSessionEntitiesByStatus_Description(EStatus.COMPLETED.toString()));
        sessionCountStatisticsDTO.setActiveSession(sessionRepository.countSessionEntitiesByStatus_Description(EStatus.ACTIVE.toString()));
        return sessionCountStatisticsDTO;
    }
}

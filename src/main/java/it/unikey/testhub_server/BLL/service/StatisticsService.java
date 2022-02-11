package it.unikey.testhub_server.BLL.service;

import it.unikey.testhub_server.BLL.dto.response.SessionCountStatisticsDTO;

public interface StatisticsService {

    SessionCountStatisticsDTO getCountSessionStatistics();

}

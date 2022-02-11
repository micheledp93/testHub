package it.unikey.testhub_server.BLL.service;

import java.time.LocalDate;

public interface DispenseService {
    String averageDispenseBetweenDates(LocalDate dateBegin, LocalDate dateEnd);
}

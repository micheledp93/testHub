package it.unikey.testhub_server.BLL.service.impl;

import it.unikey.testhub_server.BLL.service.DispenseService;
import it.unikey.testhub_server.DAL.entity.Dispense;
import it.unikey.testhub_server.DAL.enums.EStatus;
import it.unikey.testhub_server.DAL.repository.DispenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DispenseServiceImpl implements DispenseService {

    @Autowired
    private DispenseRepository dispenseRepository;

    @Override
    public String averageDispenseBetweenDates(LocalDate dateBegin, LocalDate dateEnd) {
        long totalResult = 0;
        long count = 0;
        List<Dispense> dispenseList = dispenseRepository.findAll();
        for (Dispense dispense : dispenseList) {
            if (dispense.getStatus().equals(EStatus.COMPLETED) && dispense.getSession().getSessionDate().isAfter(dateBegin) && dispense.getSession().getSessionDate().isBefore(dateEnd)) {
                totalResult += dispense.getResult();
                count++;
            }
        }
        if (count == 0) {
            return "Non ci sono somministrazioni completate";
        }
        long finalResult = totalResult / count;
        return finalResult + "%";
    }
}


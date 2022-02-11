package it.unikey.testhub_server.BLL.dto.request;

import it.unikey.testhub_server.BLL.dto.response.AssessmentResponseDTO;
import it.unikey.testhub_server.DAL.entity.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SessionRequestDTO {

    private LocalDate sessionDate;
    private Status status;
    private AssessmentResponseDTO assessment;
    private List<DispenseRequestDTO> dispenses;
}

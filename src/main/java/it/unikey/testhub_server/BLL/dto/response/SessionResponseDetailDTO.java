package it.unikey.testhub_server.BLL.dto.response;
import it.unikey.testhub_server.DAL.entity.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SessionResponseDetailDTO {

    private Long id;
    private LocalDate SessionDate;
    private Status status;
    private AssessmentResponseDTO assessmentResponseDTO;
    private List<DispenseResponseDTO> dispenses;

}

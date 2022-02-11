package it.unikey.testhub_server.BLL.dto.response;

import it.unikey.testhub_server.DAL.entity.Status;
import lombok.Data;

import java.time.LocalDate;


@Data
public class SessionResponseDTO {

    private Long id;
    private LocalDate SessionDate;
    private Status status;
    private AssessmentResponseDTO assessmentResponseDTO;


}

package it.unikey.testhub_server.BLL.dto.response;

import lombok.Data;

@Data
public class AnswerResponseDTO {

    private Long id;
    private String body;
    private Boolean correct;
}

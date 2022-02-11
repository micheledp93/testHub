package it.unikey.testhub_server.BLL.dto.request;

import lombok.Data;

@Data
public class AnswerRequestDTO {

    private String body;
    private QuestionRequestDTO question;
    private Boolean correct;
}

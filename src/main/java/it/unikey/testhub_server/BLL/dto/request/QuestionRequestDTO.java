package it.unikey.testhub_server.BLL.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class QuestionRequestDTO {

    private Long id;
    private String body;
    private Boolean mandatory;
    private List<AnswerRequestDTO> answers;
    private List<TagRequestDTO> tags;
    private Double percentage;
}

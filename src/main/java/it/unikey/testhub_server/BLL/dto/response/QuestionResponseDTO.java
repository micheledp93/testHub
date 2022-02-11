package it.unikey.testhub_server.BLL.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class QuestionResponseDTO {

    private Long id;
    private String body;
    private Boolean given;
    private Boolean mandatory;
    private Boolean active;
    private List<AnswerResponseDTO> answers;
    private Double percentage;
    private List<TagResponseDTO> tags;

}

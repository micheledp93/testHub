package it.unikey.testhub_server.BLL.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class  AssessmentResponseDTO {
    private Long id;
    private String name;
    private Double maxScore;
    private Boolean given;
    private List<TagResponseDTO> tags;
    private List<QuestionResponseDTO> questions;


}

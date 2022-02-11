package it.unikey.testhub_server.BLL.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class  AssessmentRequestDTO {

    private String name;
    private List<TagRequestDTO> tags;
    private List<QuestionRequestDTO> questions;
}
package it.unikey.testhub_server.BLL.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class AssessmentPaginatorResponseDTO {

    private List<AssessmentResponseDTO> assessmentResponseDTOList;
    private Long assessmentQuantity;

}

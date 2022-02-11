package it.unikey.testhub_server.BLL.dto.response;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class QuestionPaginatorResponseDTO {

    private List<QuestionResponseDTO> questionResponseDTOList;
    private Long questionQuantity;

}

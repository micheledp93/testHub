package it.unikey.testhub_server.BLL.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class SessionPaginatorResponseDTO {

    private List<SessionResponseDTO> sessionResponseDTOList;
    private Long sessionQuantity;

}

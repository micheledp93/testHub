package it.unikey.testhub_server.BLL.dto.response;

import it.unikey.testhub_server.DAL.entity.Status;
import it.unikey.testhub_server.DAL.entity.UserEntity;
import it.unikey.testhub_server.DAL.enums.EStatus;
import lombok.Data;

@Data
public class DispenseResponseDTO {

    private Long id;
    private Status status;
    private Long result;
    private UserResponseDTO userEntity;
}

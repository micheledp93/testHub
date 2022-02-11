package it.unikey.testhub_server.BLL.dto.request;

import it.unikey.testhub_server.DAL.entity.Status;
import lombok.Data;

@Data
public class DispenseRequestDTO {

    private Status status;
    private Long result;
    private UserRequestDTO userEntity;
}
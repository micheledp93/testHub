package it.unikey.testhub_server.BLL.dto.request;

import lombok.Data;

@Data
public class UserRequestDTO {

    private String code;
    private String firstName;
    private String lastName;
    private String mail;
}

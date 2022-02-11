package it.unikey.testhub_server.BLL.dto.response;

import it.unikey.testhub_server.DAL.entity.Dispense;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class UserResponseDTO {

    private Long id;
    private String code;
    private String firstName;
    private String lastName;
    private String mail;
}

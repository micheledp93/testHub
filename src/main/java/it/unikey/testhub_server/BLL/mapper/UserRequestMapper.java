package it.unikey.testhub_server.BLL.mapper;

import it.unikey.testhub_server.BLL.dto.request.UserRequestDTO;
import it.unikey.testhub_server.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.testhub_server.DAL.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestMapper extends GenericRequestMapper<UserEntity, UserRequestDTO> {
}

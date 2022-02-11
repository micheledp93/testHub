package it.unikey.testhub_server.BLL.mapper;


import it.unikey.testhub_server.BLL.dto.response.UserResponseDTO;
import it.unikey.testhub_server.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.testhub_server.DAL.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface UserResponseMapper extends GenericResponseMapper<UserEntity, UserResponseDTO> {
}

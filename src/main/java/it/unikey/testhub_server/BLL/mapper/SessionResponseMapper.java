package it.unikey.testhub_server.BLL.mapper;

import it.unikey.testhub_server.BLL.dto.response.SessionResponseDTO;
import it.unikey.testhub_server.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.testhub_server.DAL.entity.SessionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SessionResponseMapper extends GenericResponseMapper<SessionEntity, SessionResponseDTO> {
}

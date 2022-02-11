package it.unikey.testhub_server.BLL.mapper;

import it.unikey.testhub_server.BLL.dto.response.SessionResponseDetailDTO;

import it.unikey.testhub_server.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.testhub_server.DAL.entity.SessionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface SessionDetailResponseMapper extends GenericResponseMapper<SessionEntity, SessionResponseDetailDTO> {
}

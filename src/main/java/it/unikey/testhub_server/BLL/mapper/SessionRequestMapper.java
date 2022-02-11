package it.unikey.testhub_server.BLL.mapper;

import it.unikey.testhub_server.BLL.dto.request.SessionRequestDTO;
import it.unikey.testhub_server.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.testhub_server.DAL.entity.SessionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SessionRequestMapper extends GenericRequestMapper <SessionEntity, SessionRequestDTO> {

}

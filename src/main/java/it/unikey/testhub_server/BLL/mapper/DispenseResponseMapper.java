package it.unikey.testhub_server.BLL.mapper;

import it.unikey.testhub_server.BLL.dto.response.DispenseResponseDTO;
import it.unikey.testhub_server.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.testhub_server.DAL.entity.Dispense;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface DispenseResponseMapper extends GenericResponseMapper<Dispense, DispenseResponseDTO> {
}

package it.unikey.testhub_server.BLL.mapper;

import it.unikey.testhub_server.BLL.dto.request.DispenseRequestDTO;
import it.unikey.testhub_server.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.testhub_server.DAL.entity.Dispense;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DispenseRequestMapper extends GenericRequestMapper<Dispense, DispenseRequestDTO> {
}

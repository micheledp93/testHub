package it.unikey.testhub_server.BLL.mapper;

import it.unikey.testhub_server.BLL.dto.request.AssessmentRequestDTO;
import it.unikey.testhub_server.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.testhub_server.DAL.entity.Assessment;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface AssessmentRequestMapper extends GenericRequestMapper<Assessment, AssessmentRequestDTO> {

}

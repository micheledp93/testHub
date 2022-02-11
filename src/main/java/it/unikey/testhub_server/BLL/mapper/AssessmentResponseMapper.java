package it.unikey.testhub_server.BLL.mapper;

import it.unikey.testhub_server.BLL.dto.response.AssessmentResponseDTO;
import it.unikey.testhub_server.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.testhub_server.DAL.entity.Assessment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssessmentResponseMapper extends GenericResponseMapper<Assessment, AssessmentResponseDTO> {
}

package it.unikey.testhub_server.BLL.mapper;

import it.unikey.testhub_server.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.testhub_server.BLL.dto.response.QuestionResponseDTO;
import it.unikey.testhub_server.DAL.entity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionResponseMapper extends GenericResponseMapper<Question, QuestionResponseDTO> {

}

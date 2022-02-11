package it.unikey.testhub_server.BLL.mapper;

import it.unikey.testhub_server.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.testhub_server.BLL.dto.request.QuestionRequestDTO;
import it.unikey.testhub_server.DAL.entity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionRequestMapper extends GenericRequestMapper<Question, QuestionRequestDTO> {
}

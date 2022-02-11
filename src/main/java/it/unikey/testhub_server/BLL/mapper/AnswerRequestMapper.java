package it.unikey.testhub_server.BLL.mapper;

import it.unikey.testhub_server.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.testhub_server.BLL.dto.request.AnswerRequestDTO;
import it.unikey.testhub_server.DAL.entity.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerRequestMapper extends GenericRequestMapper<Answer, AnswerRequestDTO> {
}

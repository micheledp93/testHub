package it.unikey.testhub_server.BLL.mapper;

import it.unikey.testhub_server.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.testhub_server.BLL.dto.response.AnswerResponseDTO;
import it.unikey.testhub_server.DAL.entity.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerResponseMapper extends GenericResponseMapper<Answer, AnswerResponseDTO> {

}

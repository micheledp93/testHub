package it.unikey.testhub_server.BLL.mapper;

import it.unikey.testhub_server.BLL.mapper.abstraction.GenericResponseMapper;
import it.unikey.testhub_server.BLL.dto.response.TagResponseDTO;
import it.unikey.testhub_server.DAL.entity.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagResponseMapper extends GenericResponseMapper<Tag, TagResponseDTO> {
}

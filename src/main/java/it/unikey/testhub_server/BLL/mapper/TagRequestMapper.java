package it.unikey.testhub_server.BLL.mapper;

import it.unikey.testhub_server.BLL.mapper.abstraction.GenericRequestMapper;
import it.unikey.testhub_server.BLL.dto.request.TagRequestDTO;
import it.unikey.testhub_server.DAL.entity.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagRequestMapper extends GenericRequestMapper<Tag, TagRequestDTO> {
}
